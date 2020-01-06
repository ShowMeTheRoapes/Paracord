package com.showmetheroapes.paracord.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.showmetheroapes.paracord.models.domain.StrandModel;
import com.showmetheroapes.paracord.models.dto.StrandDTO;
import com.showmetheroapes.paracord.repositories.StrandRepository;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StrandServiceTest {
  @Mock StrandRepository strandRepository;

  @InjectMocks StrandService strandService;

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
    StrandModel strand = new StrandModel("name1", "127.0.0.1");
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
    StrandModel strand = new StrandModel("name1", "127.0.0.1");
    given(strandRepository.save(any(StrandModel.class))).willReturn(strand);

    // when
    StrandDTO.Request request = new StrandDTO.Request("name1", "127.0.0.1");
    StrandModel result = strandService.createStrand(request);

    // then
    assertEquals(strand.getIpAddress(), result.getIpAddress());
    assertEquals(strand.getName(), result.getName());
    assertEquals(strand.getId(), result.getId());
  }
}
