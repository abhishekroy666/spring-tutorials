package com.greeting;

public class GreetingServiceImpl implements GreetingService {
	
	@Override
	public String sayGreeting() {
		// TODO Auto-generated method stub
		return "Hello World";
	}
	
	
	public GreetingServiceImpl() {
		super();
		System.out.println("Constructor invoked...");
	}
	

}
