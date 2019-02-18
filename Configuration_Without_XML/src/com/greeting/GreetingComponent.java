package com.greeting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingComponent {
	@Bean
	public GreetingService hello(){
		return new HelloGreetingService();
	}
	
	@Bean
	public GreetingService welcome(){
		return new WelcomeGreetingService(); 
	}
	
}
