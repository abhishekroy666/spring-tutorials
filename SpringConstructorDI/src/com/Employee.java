package com;

public class Employee {
	private int id;
	private String name;
	private float salary;
	
	Employee(){
		System.out.println("Object Created");
	}
	
	public Employee(int id, String name, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		System.out.println("Parameterized constructor created");
	}

	public void display(){
		System.out.println("Business Method");
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ "]";
	}	
}
