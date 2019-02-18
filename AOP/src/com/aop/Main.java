package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("spring-config.xml");
		Performer performer = (Performer)ctx.getBean("myInstrumentalist");
		//System.out.println(performer.getClass().getName());
		performer.perform();
		
		performer = (Performer)ctx.getBean("mySinger");
		//System.out.println(performer.getClass().getName());
		performer.perform();
		}
		catch(RuntimeException ex){
			ex.printStackTrace();
		}
	}

}
