package com.showmetheroapes.paracord.models.dto;

import com.showmetheroapes.paracord.models.domain.StrandModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class StrandDTO {
  @NoArgsConstructor
  @Getter
  @Setter
  public static class Request {
    private String ipAddress = "Not Provided";
    private String name = "Not Provided";
    private int port = 0;

    public Request(String ipAddress, String name, int port) {
      this.ipAddress = ipAddress;
      this.name = name;
      this.port = port;
    }
  }

  @NoArgsConstructor
  @Getter
  @Setter
  public static class Response {
    private String ipAddress;
    private String name;
    private int port;

    public Response(String ipAddress, String name, int port) {
      this.ipAddress = ipAddress;
      this.name = name;
      this.port = port;
    }

    public Response(StrandModel model) {
      this.ipAddress = model.getIpAddress();
      this.name = model.getName();
      this.port = model.getPort();
    }
  }
}
