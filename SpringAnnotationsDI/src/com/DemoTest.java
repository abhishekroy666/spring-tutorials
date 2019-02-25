package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DemoTest {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp = (Employee)ac.getBean("emp");
		System.out.println(emp);
		
		Address add = emp.getAddress();
		add.setCity("Bangalore");
		add.setState("Karnataka");		
		
		emp.setId(100);
		emp.setName("Raj");
		emp.setSalary(12000);
		emp.setAddress(add);
		
		System.out.println(emp);
		

	}

}
