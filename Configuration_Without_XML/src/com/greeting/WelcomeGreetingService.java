package com.greeting;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class WelcomeGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		// TODO Auto-generated method stub
		return "Welcome";
	}
	
	@PostConstruct
	public void initialize(){
		System.out.println("Initializing bean...");
	}
	
	@PreDestroy
	public void clear(){
		System.out.println("Clearing bean...");
	}

}
