package com.wedding.spring.data.mongodb.controller;

import com.wedding.spring.data.mongodb.model.GuestList;
import com.wedding.spring.data.mongodb.repository.GuestListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class GuestListController {

  @Autowired
  GuestListRepository tutorialRepository;


  @GetMapping("/guests")
  public ResponseEntity<List<GuestList>> getAllTutorials(@RequestParam(required = false) String firstName) {
    try {
      List<GuestList> tutorials = new ArrayList<GuestList>();

      if (firstName == null)
        tutorialRepository.findAll().forEach(tutorials::add);
      else
        tutorialRepository.findByFirstName(firstName).forEach(tutorials::add);

      if (tutorials.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
    @PostMapping("/addGuest")
    public ResponseEntity<GuestList> addGuest(@RequestBody GuestList tutorial) {
      try {
        GuestList _tutorial = tutorialRepository.save(tutorial);
        return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
      } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

  @PostMapping("/addMultipleGuest")
  public ResponseEntity<String> addAllGuests(@RequestBody List<GuestList> guestList) {
    try {
      for(GuestList tutorial : guestList) {
        tutorialRepository.save(tutorial);
      }
      return new ResponseEntity<>("All quests have been added the list successfully", HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
