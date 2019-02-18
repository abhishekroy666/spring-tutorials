package com.greeting;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GreetingComponent {
	@Bean(name = "greetingService")
	public GreetingService getGreetingService(){
		return new GreetingServiceImpl();
	}
	
	@Bean(name="hello")
	public Service getHelloService(){
		return new HelloService(); 
	}
	
	@Bean(name="welcome")
	public Service getWelcomeService(){
		return new WelcomeService(); 
	}
	
	
	
}
