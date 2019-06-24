package com.showmetheroapes.example.domain;

/** @author Dustin Roan (dustin.a.roan@gmail.com) */
public class User {
  private final String userId;

  private User(final String userId) {
    this.userId = userId;
  }

  public String user() {
    return this.userId;
  }

  public static class Builder {
    private String userId;

    public Builder user(final String userId) {
      this.userId = userId;
      return this;
    }

    public Builder reset() {
      this.userId = null;
      return this;
    }

    public User build() {
      return new User(this.userId);
    }
  }
}
