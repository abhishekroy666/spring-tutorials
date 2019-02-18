package com.trigo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring-config.xml");
		CircleData cData = (CircleData)ctx.getBean("myCircleData");
		System.out.println("Area: " + cData.getArea());
		System.out.println("Perimeter: " + cData.getCircumference());
		System.out.println("The circle is larger in size: " + cData.isBig());
		
	}

}
