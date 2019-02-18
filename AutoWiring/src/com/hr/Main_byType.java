package com.hr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main_byType {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring-config_byType.xml");
		Employee emp = (Employee)ctx.getBean("emp1");
		System.out.println(emp);
		
	}

}
