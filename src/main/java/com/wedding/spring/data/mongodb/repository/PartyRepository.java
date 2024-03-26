package com.wedding.spring.data.mongodb.repository;

import com.wedding.spring.data.mongodb.model.Party;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartyRepository extends MongoRepository<Party, String> {

}
