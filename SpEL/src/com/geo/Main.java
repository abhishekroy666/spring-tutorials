package com.geo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring-config.xml");
		CityData cData = (CityData)ctx.getBean("myCityData");
		System.out.println(cData.getBigCities());
		System.out.println(cData.getSmallCities());
		System.out.println(cData.getSelectedCity());
		
	}

}
