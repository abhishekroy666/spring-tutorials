package bean;

import java.io.Serializable;

public class Emp implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private float sal;
	
	//default constructor
	public Emp() {
		super();
	}
	
	//parameterized constructor
	public Emp(int id, String name, float sal) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
	}

	//setter and getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}

	//toString
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}			
}
