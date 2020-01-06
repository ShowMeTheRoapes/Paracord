package com.showmetheroapes.paracord.controllers;

import com.showmetheroapes.paracord.models.dto.StrandDTO.Request;
import com.showmetheroapes.paracord.models.dto.StrandDTO.Response;
import com.showmetheroapes.paracord.services.StrandService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/strands")
public class StrandController {
  private StrandService strandService;

  @Autowired
  public StrandController(StrandService strandService) {
    this.strandService = strandService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Response> getAll() {
    return strandService.getAllStrands().stream().map(Response::new).collect(Collectors.toList());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Response createStrand(@RequestBody Request request) {
    return new Response(strandService.createStrand(request));
  }
}
