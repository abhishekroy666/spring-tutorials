package com.hr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		test();
	}
	private static void test(){
		//ApplicationContext ctx = new FileSystemXmlApplicationContext("spring-config.xml");
		ConfigurableApplicationContext ctx = new FileSystemXmlApplicationContext("spring-config.xml");
		Employee emp = (Employee)ctx.getBean("emp1");
		System.out.println("Application Context from Main: " + ctx.hashCode());
		String empName = emp.getName();
		System.out.println("Employee Name: " + empName);
		ctx.close();
	}

}












