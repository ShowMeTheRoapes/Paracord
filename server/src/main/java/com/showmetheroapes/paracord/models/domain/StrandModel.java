package com.showmetheroapes.paracord.models.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "strands")
@NoArgsConstructor
@Setter
@Getter
public class StrandModel {
  @Id private ObjectId id;
  private String name;
  private String ipAddress;
  private int port;

  public StrandModel(String name, String ipAddress, int port) {
    this.name = name;
    this.ipAddress = ipAddress;
    this.port = port;
  }

  @Override
  public String toString() {
    return String.format("Strand{name='%s', ipAddress='%s', port=%d}", name, ipAddress, port);
  }
}
