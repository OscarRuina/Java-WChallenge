package com.java.WChallenge.entities;

import javax.persistence.Entity;

@Entity
public class Address {
	
	private String street;
	private String suit;
	private String city;
	private String zipcode;
	private Geo geo;
	
	public Address() {}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Geo getGeo() {
		return geo;
	}

	public void setGeo(Geo geo) {
		this.geo = geo;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", suit=" + suit + ", city=" + city + ", zipcode=" + zipcode + ", geo="
				+ geo + "]";
	}
	
	

}
