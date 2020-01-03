package com.showmetheroapes.paracord.models;

public class StrandDTO {
  public static class Request {
    private String ipAddress = "Not Provided";
    private String name = "Not Provided";

    public Request() {}

    public String getIpAddress() {
      return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
      this.ipAddress = ipAddress;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  public static class Response {
    private String ipAddress;
    private String name;

    public Response(String ipAddress, String name) {
      this.ipAddress = ipAddress;
      this.name = name;
    }

    public Response(StrandModel model) {
      this.ipAddress = model.getIpAddress();
      this.name = model.getName();
    }

    public String getIpAddress() {
      return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
      this.ipAddress = ipAddress;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }
}
