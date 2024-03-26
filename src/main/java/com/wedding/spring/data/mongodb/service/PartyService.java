package com.wedding.spring.data.mongodb.service;

import com.wedding.spring.data.mongodb.model.GuestList;
import com.wedding.spring.data.mongodb.model.Party;
import com.wedding.spring.data.mongodb.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PartyService {

    @Autowired
    private PartyRepository partyRepository;

    public ResponseEntity<String> addPartyFromGuestList(List<GuestList> guestList) {
        Map<String, Long> partyMap = guestList.stream()
                .collect(Collectors.groupingBy(
                        GuestList::getPartyName,
                        HashMap::new,
                        Collectors.counting()
                ));
        for (Map.Entry<String, Long> entry : partyMap.entrySet()) {
            String partyName = entry.getKey();
            Long partyNumber = entry.getValue();
            List<Party> partyList = partyRepository.findAll();
            if(!isInList(partyList,partyName)) {
                partyRepository.save(new Party(partyName, Math.toIntExact(partyNumber),false, false, false));
            }
        }
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }


    private boolean isInList(List<Party> partyList, String partyName) {
        if(partyList.isEmpty()){
            return false;
        }
        for(Party p : partyList){
            if(p.getPartyName().equalsIgnoreCase(partyName)){
                return true;
            }
        }
        return false;
    }
}
