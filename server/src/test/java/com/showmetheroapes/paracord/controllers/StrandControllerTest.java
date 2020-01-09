package com.showmetheroapes.paracord.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.showmetheroapes.paracord.models.domain.StrandModel;
import com.showmetheroapes.paracord.models.dto.StrandDTO;
import com.showmetheroapes.paracord.services.StrandService;
import java.util.Arrays;
import java.util.List;
import org.bson.types.ObjectId;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(controllers = StrandController.class)
public class StrandControllerTest {
  @Autowired private MockMvc mockMvc;

  @MockBean private StrandService strandService;

  @Test
  public void findAllStrandsReturnsAListOfStrands() throws Exception {
    // given
    StrandModel strand1 = setupStrandModel("name1", "127.0.0.1", 25565);
    StrandModel strand2 = setupStrandModel("name2", "127.0.0.1", 25566);
    List<StrandModel> strands = Arrays.asList(strand1, strand2);
    given(strandService.getAllStrands()).willReturn(strands);

    // when
    ResultActions results = mockMvc.perform(get("/api/v1/strands"));

    // then
    results
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.length()", new IsEqual<>(strands.size())))
        .andExpect(jsonPath("$.[0].name", new IsEqual<>(strand1.getName())))
        .andExpect(jsonPath("$.[0].ipAddress", new IsEqual<>(strand1.getIpAddress())))
        .andExpect(jsonPath("$.[0].port", new IsEqual<>(strand1.getPort())));
  }

  @Test
  public void createStrandReturnsACreatedStrand() throws Exception {
    // given
    String name = "name1";
    String ipAddress = "127.0.0.1";
    int port = 25565;
    StrandModel strand = setupStrandModel(name, ipAddress, port);
    given(strandService.createStrand(any(StrandDTO.Request.class))).willReturn(strand);

    // when
    ResultActions results =
        mockMvc.perform(
            post("/api/v1/strands")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    String.format(
                        "{\"name\": \"%s\", \"ipAddress\": \"%s\", \"port\": %d}",
                        name, ipAddress, port)));

    // then
    results
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.name", new IsEqual<>(strand.getName())))
        .andExpect(jsonPath("$.ipAddress", new IsEqual<>(strand.getIpAddress())));
  }

  private StrandModel setupStrandModel(String name, String ipAddress, int port) {
    StrandModel strand = new StrandModel(name, ipAddress, port);
    strand.setId(ObjectId.get());
    return strand;
  }
}
