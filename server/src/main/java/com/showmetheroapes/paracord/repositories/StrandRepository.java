package com.showmetheroapes.paracord.repositories;

import com.showmetheroapes.paracord.models.StrandModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StrandRepository extends MongoRepository<StrandModel, Integer> {
  public StrandModel findByIpAddress(String ipAddress);
}
