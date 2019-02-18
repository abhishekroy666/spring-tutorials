package com.greeting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ApplicationContext ctx;
		ctx = new FileSystemXmlApplicationContext("spring-config.xml");
		GreetingService service1;
		service1 = (GreetingService)ctx.getBean("bean1");
		String message = service1.sayGreeting();
		System.out.println(message);
		System.out.println(service1.getClass().getName());
		
		
		
	}
}












