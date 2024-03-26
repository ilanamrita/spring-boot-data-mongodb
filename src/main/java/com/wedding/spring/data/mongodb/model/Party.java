package com.wedding.spring.data.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "party")
public class Party {
    @Id
    private String id;
    private String partyName;
    private int partyNumber;
    private Boolean isSaveTheDate;
    private Boolean isInvitation;
    private Boolean hasRSVPed;

    public Party(){

    }
    public Party( String partyName, int partyNumber, Boolean isSaveTheDate, Boolean isInvitation, Boolean hasRSVPed) {

        this.partyName = partyName;
        this.partyNumber = partyNumber;
        this.isSaveTheDate = isSaveTheDate;
        this.isInvitation = isInvitation;
        this.hasRSVPed = hasRSVPed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public int getPartyNumber() {
        return partyNumber;
    }

    public void setPartyNumber(int partyNumber) {
        this.partyNumber = partyNumber;
    }

    public Boolean getSaveTheDate() {
        return isSaveTheDate;
    }

    public void setSaveTheDate(Boolean saveTheDate) {
        isSaveTheDate = saveTheDate;
    }

    public Boolean getInvitation() {
        return isInvitation;
    }

    public void setInvitation(Boolean invitation) {
        isInvitation = invitation;
    }

    public Boolean getHasRSVPed() {
        return hasRSVPed;
    }

    public void setHasRSVPed(Boolean hasRSVPed) {
        this.hasRSVPed = hasRSVPed;
    }



    @Override
    public String toString() {
        return "Party{" +
                "id='" + id + '\'' +
                ", partyName='" + partyName + '\'' +
                ", partyNumber=" + partyNumber +
                ", isSaveTheDate=" + isSaveTheDate +
                ", isInvitation=" + isInvitation +
                ", hasRSVPed=" + hasRSVPed +
                '}';
    }


}
