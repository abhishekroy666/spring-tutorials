package com;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DemoTest {

	public static void main(String[] args) {
		//new Employee().display();
		
		Resource res = new ClassPathResource("beans.xml");
		BeanFactory factory = new XmlBeanFactory(res);
		Employee e1 = (Employee)factory.getBean("obj1");
		System.out.println(e1);
		
		Employee e2 = (Employee)factory.getBean("obj2");
		System.out.println(e2);
		
		Employee e3 = (Employee)factory.getBean("obj3");
		System.out.println(e3);
		
	}
}
