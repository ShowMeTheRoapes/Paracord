package com.showmetheroapes.paracord.services;

import com.showmetheroapes.paracord.models.domain.StrandModel;
import com.showmetheroapes.paracord.models.dto.StrandDTO.Request;
import com.showmetheroapes.paracord.repositories.StrandRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class StrandService {
  private static final Logger logger = LoggerFactory.getLogger(StrandService.class);

  private StrandRepository strandRepository;
  private RestTemplate restTemplate;

  @Autowired
  public StrandService(StrandRepository strandRepository, RestTemplate restTemplate) {
    this.strandRepository = strandRepository;
    this.restTemplate = restTemplate;
  }

  public List<StrandModel> getAllStrands() {
    return strandRepository.findAll();
  }

  public StrandModel createStrand(Request request) {
    StrandModel strand =
        StrandModel.builder()
            .name(request.getName())
            .ipAddress(request.getIpAddress())
            .port(request.getPort())
            .build();
    return strandRepository.save(strand);
  }

  // Run strands check every 10 minutes
  @Scheduled(fixedDelayString = "${schedule.strandAvailabilityMS}")
  public void checkStrandsAvailability() {
    logger.info("Starting Strand availability cron job.");
    List<StrandModel> strands = strandRepository.findAll();
    strands.forEach(
        strand -> {
          try {
            logger.info("Getting health status of " + strand.getFullAddress());
            ResponseEntity<String> response =
                restTemplate.getForEntity(
                    "https://" + strand.getFullAddress() + "/health", String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
              strand.setAvailable(true);
            } else {
              logger.error(
                  "Strand " + strand.getName() + " failed the health check with a non-200 status.");
              strand.setAvailable(false);
            }
          } catch (RestClientException ex) {
            logger.error(
                "Strand "
                    + strand.getName()
                    + " failed the health check with the following error: "
                    + ex.getMessage());
            strand.setAvailable(false);
          }
        });
    strandRepository.saveAll(strands);
    logger.info("Finished Strand availability cron job.");
  }
}
