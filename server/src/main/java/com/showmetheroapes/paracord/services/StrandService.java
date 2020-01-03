package com.showmetheroapes.paracord.services;

import com.showmetheroapes.paracord.models.StrandDTO.Request;
import com.showmetheroapes.paracord.models.StrandModel;
import com.showmetheroapes.paracord.repositories.StrandRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrandService {
  @Autowired private StrandRepository strandRepository;

  public List<StrandModel> getAllStrands() {
    return strandRepository.findAll();
  }

  public StrandModel getStrandByIpAddress(String ipAddress) {
    return strandRepository.findByIpAddress(ipAddress);
  }

  public StrandModel createStrand(Request request) {
    StrandModel strand = new StrandModel(request.getName(), request.getIpAddress());
    return strandRepository.save(strand);
  }
}
