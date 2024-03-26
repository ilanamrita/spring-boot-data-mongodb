package com.wedding.spring.data.mongodb.controller;

import com.wedding.spring.data.mongodb.model.GuestList;
import com.wedding.spring.data.mongodb.model.Party;
import com.wedding.spring.data.mongodb.repository.GuestListRepository;
import com.wedding.spring.data.mongodb.repository.PartyRepository;
import com.wedding.spring.data.mongodb.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PartyController {

  @Autowired
  PartyRepository tutorialRepository;

  @Autowired
  PartyService partyService;

  @Autowired
  GuestListRepository guestListRepository;


  @PostMapping("/addParty")
  public ResponseEntity<Party> createTutorial(@RequestBody Party tutorial) {
    try {
      Party _tutorial = tutorialRepository.save(new Party( tutorial.getPartyName(),  tutorial.getPartyNumber(), false,false, false));
      return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/addParty")
  public void createTutorial() {
    try {

      List<GuestList> guestLists = guestListRepository.findAll();
      partyService.addPartyFromGuestList(guestLists);

    } catch (Exception e) {

    }
  }







}
