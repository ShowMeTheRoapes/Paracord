package com.showmetheroapes.paracord.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/strands", produces = "application/json")
public class StrandController {

  /**
   * Endpoint to get all of the currently available strands
   *
   * @return a list of strand names
   */
  @GetMapping
  public List<String> findAll() {
    final List<String> strands = new ArrayList<>();
    strands.add("Test");
    return strands;
  }
}
