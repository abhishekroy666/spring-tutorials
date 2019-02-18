package com.geo;

public class City {
	private String name;
	private int population;
	public City() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String toString(){
		return name + ", " + population;
	}
}
