package com.greeting;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;



public class GreetingServiceImpl implements GreetingService{

	@Resource(name = "welcome")
	private Service myService;
	public GreetingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sayGreeting() {
		// TODO Auto-generated method stub
		return myService.invoke();
	}
	
	
	
}
