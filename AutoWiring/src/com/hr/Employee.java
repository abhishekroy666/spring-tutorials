package com.hr;

public class Employee {
		private int empId, sal;
		private String name;
		private Address address;
		private Contact contact;
		
	public Employee() {
		// TODO Auto-generated constructor stub
		System.out.println("No Arg");
	}
	
	public Employee(int empId, String name, int sal, Address address, Contact contact) {
		super();
		System.out.println("First");
		this.empId = empId;
		this.name = name;
		this.sal = sal;
		this.address = address;		
		this.contact = contact;
	}
	
	
	public Employee(String name, int sal, int empId, Address address, Contact contact) {
		super();
		System.out.println("Second");
		this.empId = empId;
		this.name = name;
		this.sal = sal;
		this.address = address;		
		this.contact = contact;
	}
	
	
	public Employee(Contact contact, Address address) {
		super();
		System.out.println("Third");
		this.address = address;
		this.contact = contact;
	}
	public Employee(Address address, Contact contact) {
		super();
		System.out.println("Fourth");
		this.address = address;
		this.contact = contact;
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
		return empId + ", " + name + ", " + sal + ", " + address + ", " + contact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}		
}
