package com.hr;
public class Employee {
		private int empId, sal;
		private String name;
		private Address address;

	public Employee() {
		// TODO Auto-generated constructor stub
		System.out.println("Default");
	}
	
	public Employee(int empId, String name, int sal, Address address) {
		super();
		this.empId = empId;
		this.name = name;
		this.sal = sal;
		this.address = address;		
	}
	
	public Employee(String name, int sal, int empId, Address address) {
		super();
		this.empId = empId;
		this.name = name;
		this.sal = sal;
		this.address = address;		
	}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return empId + ", " + name + ", " + sal + ", " + address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}	
}
