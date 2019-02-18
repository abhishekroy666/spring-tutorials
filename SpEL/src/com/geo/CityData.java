package com.geo;

import java.util.List;

public class CityData {
	private List<City> bigCities, smallCities;
	private City selectedCity;
	public CityData() {
		// TODO Auto-generated constructor stub
	}
	public List<City> getBigCities() {
		return bigCities;
	}
	public void setBigCities(List<City> bigCities) {
		this.bigCities = bigCities;
	}
	public List<City> getSmallCities() {
		return smallCities;
	}
	public void setSmallCities(List<City> smallCities) {
		this.smallCities = smallCities;
	}
	public City getSelectedCity() {
		return selectedCity;
	}
	public void setSelectedCity(City selectedCity) {
		this.selectedCity = selectedCity;
	}
}
