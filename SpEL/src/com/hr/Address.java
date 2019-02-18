package com.hr;

public class Address {
	private String city, state, zip;

	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public Address(String city, String state, String zip) {
		super();
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String toString() {
		return city + ", " + state + ", " + zip;
	}
	
}
