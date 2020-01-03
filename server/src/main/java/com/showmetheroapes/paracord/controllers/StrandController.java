package com.showmetheroapes.paracord.controllers;

import com.showmetheroapes.paracord.models.StrandDTO.Request;
import com.showmetheroapes.paracord.models.StrandDTO.Response;
import com.showmetheroapes.paracord.services.StrandService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/strands", produces = "application/json")
public class StrandController {
  @Autowired private StrandService strandService;

  @GetMapping
  public List<Response> getAll() {
    return strandService.getAllStrands().stream()
        .map(strand -> new Response(strand))
        .collect(Collectors.toList());
  }

  // Requires the last / because ip addresses have "."
  @GetMapping("/{ipAddress}/")
  public Response getByIpAddress(@RequestParam String ipAddress) {
    return new Response(strandService.getStrandByIpAddress(ipAddress));
  }

  @PostMapping
  public Response createStrand(@RequestBody Request request) {
    return new Response(strandService.createStrand(request));
  }
}
