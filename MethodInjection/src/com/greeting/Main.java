package com.greeting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring-config.xml");
		GreetingService service = (GreetingService)ctx.getBean("bean1");
		
		String message = service.sayGreeting("Hello", "James");
		System.out.println(message);
		
		service = (GreetingService)ctx.getBean("bean2");
		message = service.sayGreeting("Hello", "James");
		System.out.println(message);
	}

}
