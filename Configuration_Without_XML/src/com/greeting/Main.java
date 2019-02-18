package com.greeting;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(GreetingComponent.class);
		GreetingService service = ctx.getBean("hello", GreetingService.class);
		String message = service.sayGreeting();
		System.out.println(message);
		ctx.close();
	}

}
