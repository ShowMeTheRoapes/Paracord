package com.showmetheroapes.paracord.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class StrandControllerTest {

  private StrandController strandController;

  @Before
  public final void setUp() {
    strandController = new StrandController();
  }

  @Test
  public final void testFindAllReturnsListOfNames() {
    final List<String> expected = new ArrayList<>();
    expected.add("Test");
    assertEquals(expected, strandController.findAll());
  }
}
