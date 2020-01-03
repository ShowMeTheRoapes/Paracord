package com.showmetheroapes.paracord.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "strands")
public class StrandModel {
  @Id private ObjectId _id;
  private String name;
  private String ipAddress;

  public StrandModel() {}

  public StrandModel(String name, String ipAddress) {
    this.name = name;
    this.ipAddress = ipAddress;
  }

  public ObjectId getId() {
    return _id;
  }

  public void setId(ObjectId id) {
    _id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }

  @Override
  public String toString() {
    return String.format("User{name='%s', ipAddress='%s'}", name, ipAddress);
  }
}
