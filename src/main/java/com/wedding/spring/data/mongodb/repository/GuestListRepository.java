package com.wedding.spring.data.mongodb.repository;

import com.wedding.spring.data.mongodb.model.GuestList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GuestListRepository extends MongoRepository<GuestList, String> {

    List<GuestList> findByFirstName(String firstName);

}
