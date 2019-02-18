package com.greeting;

public class GreetingServiceImpl implements GreetingService {

	@Override
	public String sayGreeting(String message, String name) {
		// TODO Auto-generated method stub
		return message + ", " + name;
	}

}
