package service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import bean.Emp;

public class EmployeeService implements Serializable{
	private static final long serialVersionUID = 1L;
	ArrayList<Emp> al = new ArrayList<Emp>();
	public void addEmployee()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\n\n\tEnter id : ");
		int id = sc.nextInt();
		System.out.print("\tEnter name : ");
		String name = sc.next();
		System.out.print("\tEnter salary : ");
		float sal = sc.nextFloat();
		
		Iterator<Emp> itr = al.iterator();
		while(itr.hasNext())
		{
			Emp e = itr.next();
			if(e.getId()==id)
			{
				System.out.print("\n\tEmployee with this id already exists.");
				sc.close();
				return;
			}
		}
		Emp e = new Emp(id,name,sal);
		al.add(e);
		System.out.print("\n\tEmployee Added.");
		sc.close();
	}
	public void deleteEmployee()
	{
		Scanner sc = new Scanner(System.in);
		if(al.size()==0)
		{
			System.out.print("\n\tThere are no employees. ");
			sc.close();
			return;
		}
		System.out.print("\n\n\tEnter id : ");
		int id = sc.nextInt();
		Iterator<Emp> itr = al.iterator();
		while(itr.hasNext())
		{
			Emp e = itr.next();
			if(e.getId()==id)
			{
				al.remove(e);
				System.out.print("\n\tEmployee Deleted.");
				sc.close();
				return;
			}
		}
		System.out.print("\n\tEmployee not found");
		sc.close();
	}
	public void updateEmployee()
	{
		Scanner sc = new Scanner(System.in);
		if(al.size()==0)
		{
			System.out.print("\n\tThere are no employees. ");
			sc.close();
			return;
		}
		System.out.print("\n\n\tEnter id : ");
		int id = sc.nextInt();
		Iterator<Emp> itr = al.iterator();
		while(itr.hasNext())
		{
			Emp e = itr.next();
			if(e.getId()==id)
			{
				al.remove(e);
				System.out.print("\tEnter new name : ");
				String name = sc.next();
				e.setName(name);
				System.out.print("\tEnter new salary : ");
				float sal = sc.nextFloat();
				e.setSal(sal);
				al.add(e);
				System.out.print("\n\tEmployee Updated.");
				sc.close();
				return;
			}
		}
		System.out.print("\n\tEmployee not found");
		sc.close();
	}
	public void displayAllEmployees()
	{
		if(al.size()==0)
		{
			System.out.print("\n\tThere are no employees. ");
			return;
		}
		Iterator<Emp> itr = al.iterator();
		System.out.println();
		while(itr.hasNext())
		{
			Emp e = itr.next();
			System.out.println("\t"+e);
		}
	}
}
	

