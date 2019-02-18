package com.greeting;

public class GreetingServiceUser {
	private GreetingService greetingService;

	public GreetingServiceUser() {
		// TODO Auto-generated constructor stub
	}

	public GreetingService getGreetingService() {
		return greetingService;
	}

	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String greet(){
		String greeting = greetingService.sayGreeting();
		return greeting;
	}

}
