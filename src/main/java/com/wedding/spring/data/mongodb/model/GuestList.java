package com.wedding.spring.data.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document(collection = "guestList")
public class GuestList implements Serializable {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String partyName;
	private boolean weddingParty;
	private String coupleSide;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public boolean isWeddingParty() {
		return weddingParty;
	}

	public void setWeddingParty(boolean weddingParty) {
		this.weddingParty = weddingParty;
	}

	public String getCoupleSide() {
		return coupleSide;
	}

	public void setCoupleSide(String coupleSide) {
		this.coupleSide = coupleSide;
	}

	public GuestList(String firstName, String lastname, String partyName, boolean weddingParty, String coupleSide) {
		this.firstName = firstName;
		this.lastName = lastname;
		this.partyName = partyName;
		this.weddingParty = weddingParty;
		this.coupleSide = coupleSide;
	}

	public GuestList(){}

	@Override
	public String toString() {
		return "GuestList{" +
				"id='" + id + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", partyName='" + partyName + '\'' +
				", weddingParty=" + weddingParty +
				", coupleSide='" + coupleSide + '\'' +
				'}';
	}
}
