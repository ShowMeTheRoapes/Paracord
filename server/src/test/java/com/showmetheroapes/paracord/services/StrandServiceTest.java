package com.showmetheroapes.paracord.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

import com.showmetheroapes.paracord.models.domain.StrandModel;
import com.showmetheroapes.paracord.models.dto.StrandDTO;
import com.showmetheroapes.paracord.repositories.StrandRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;

@AutoConfigureWebClient(registerRestTemplate = true)
@RestClientTest(components = {StrandService.class, StrandRepository.class})
class StrandServiceTest {
  @MockBean StrandRepository strandRepository;

  @Autowired StrandService strandService;

  @Autowired MockRestServiceServer otherServer;

  @Test
  public void getAllStrandsReturnsEmptyList() {
    // given
    given(strandRepository.findAll()).willReturn(Collections.emptyList());

    // when
    List<StrandModel> results = strandService.getAllStrands();

    // then
    assertEquals(0, results.size());
  }

  @Test
  public void getAllStrandsReturnsAListOfStrands() {
    // given
    StrandModel strand =
        StrandModel.builder().name("name1").ipAddress("127.0.0.1").port(25565).build();
    given(strandRepository.findAll()).willReturn(Collections.singletonList(strand));

    // when
    List<StrandModel> results = strandService.getAllStrands();

    // then
    assertEquals(1, results.size());
    assertEquals(strand, results.get(0));
  }

  @Test
  public void createStrandReturnsCreatedStrand() {
    // given
    StrandModel strand =
        StrandModel.builder().name("name1").ipAddress("127.0.0.1").port(25565).build();
    given(strandRepository.save(any(StrandModel.class))).willReturn(strand);

    // when
    StrandDTO.Request request = new StrandDTO.Request("name1", "127.0.0.1", 25565);
    StrandModel result = strandService.createStrand(request);

    // then
    assertEquals(strand.getIpAddress(), result.getIpAddress());
    assertEquals(strand.getName(), result.getName());
    assertEquals(strand.getId(), result.getId());
    assertEquals(strand.getPort(), result.getPort());
    assertFalse(strand.isAvailable());
  }

  @Test
  public void strandHealthCheckCronJobGetsStrandAvailability() {
    // given
    List<StrandModel> strands = new ArrayList<>();
    strands.add(
        StrandModel.builder()
            .name("name1")
            .ipAddress("127.0.0.1")
            .port(25565)
            .isAvailable(true)
            .build());
    strands.add(StrandModel.builder().name("name2").ipAddress("127.0.0.1").port(25566).build());

    given(strandRepository.findAll()).willReturn(strands);

    otherServer
        .expect(
            ExpectedCount.once(),
            requestTo("https://" + strands.get(0).getFullAddress() + "/health"))
        .andExpect(method(HttpMethod.GET))
        .andRespond(withStatus(HttpStatus.NOT_FOUND));

    otherServer
        .expect(
            ExpectedCount.once(),
            requestTo("https://" + strands.get(1).getFullAddress() + "/health"))
        .andExpect(method(HttpMethod.GET))
        .andRespond(withSuccess("\"status\": \"UP\"", MediaType.APPLICATION_JSON));

    strands.forEach(it -> it.setAvailable(!it.isAvailable()));
    given(strandRepository.saveAll(strands)).willReturn(strands);

    // when
    strandService.checkStrandsAvailability();

    // then
    otherServer.verify();
  }
}
