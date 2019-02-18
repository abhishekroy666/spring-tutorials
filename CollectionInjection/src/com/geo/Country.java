package com.geo;

import java.util.Collection;

public class Country {
	private String code, name;
	private Collection<String> states;
	public Country() {
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<String> getStates() {
		return states;
	}
	public void setStates(Collection<String> states) {
		this.states = states;
	}
	@Override
	public String toString() {
		return code + ", " + name + ", " + states;
	}
}
