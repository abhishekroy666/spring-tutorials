package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp = (Employee)ac.getBean("emp");
		
		emp.setId(117);
		emp.setName("AAA");
		emp.setSalary(18000);
		
		EmployeeDao ed = (EmployeeDao)ac.getBean("empdao");
		ed.storeEmp(emp);
	}

}
