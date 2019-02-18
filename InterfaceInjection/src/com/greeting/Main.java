package com.greeting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx;
		ctx = new FileSystemXmlApplicationContext("spring-config.xml");
		GreetingServiceUser user;
		user = (GreetingServiceUser)ctx.getBean("serviceUser");
		String message = user.greet();
		System.out.println(message);
		
		
	}
}












