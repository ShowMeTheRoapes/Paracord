package com.showmetheroapes.paracord.services;

import com.showmetheroapes.paracord.models.domain.StrandModel;
import com.showmetheroapes.paracord.models.dto.StrandDTO.Request;
import com.showmetheroapes.paracord.repositories.StrandRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrandService {
  private StrandRepository strandRepository;

  @Autowired
  public StrandService(StrandRepository strandRepository) {
    this.strandRepository = strandRepository;
  }

  public List<StrandModel> getAllStrands() {
    return strandRepository.findAll();
  }

  public StrandModel createStrand(Request request) {
    StrandModel strand = new StrandModel(request.getName(), request.getIpAddress(), request.getPort());
    return strandRepository.save(strand);
  }
}
