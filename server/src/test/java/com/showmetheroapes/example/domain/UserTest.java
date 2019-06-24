/** */
package com.showmetheroapes.example.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for the {@link User} class
 *
 * @author Dustin Roan (dustin.a.roan@gmail.com)
 */
public class UserTest {

  /** Test method for {@link com.showmetheroapes.example.domain.User#user()}. */
  @Test
  public final void testUser() {
    final String testUser = "TestUser";
    final User user = new User.Builder().user(testUser).build();
    assertEquals(testUser, user.user());
  }
}
