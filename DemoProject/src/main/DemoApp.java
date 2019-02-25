package main;

import service.EmployeeService;
import java.io.*;
import java.util.Scanner;

public class DemoApp {

	private static ObjectInputStream ois;
	private static FileInputStream fis;

	public static void main(String[] args) throws Exception {
		File ff = new File("Emp_data.txt");
		EmployeeService es;
		if(ff.length()> 0)
		{
			fis = new FileInputStream(ff);
			ois = new ObjectInputStream(fis);
			es = (EmployeeService)ois.readObject();
			fis.close();
		}
		else
		{
			es = new EmployeeService();
		}		
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		do
		{
			System.out.println("\n\n\t\tEMPLOYEE SERVICE");
			System.out.println("\tPress 1 to ADD an employee.");
			System.out.println("\tPress 2 to DELETE an employee.");
			System.out.println("\tPress 3 to UPDATE an employee.");
			System.out.println("\tPress 4 to DISPLAY all employee.");
			System.out.println("\tPress 5 to EXIT.");
			System.out.print("\tEnter your choice : ");
			ch = sc.nextInt();
			
			switch(ch)
			{
			case 1:
				es.addEmployee();
				break;
			case 2:
				es.deleteEmployee();
				break;
			case 3:
				es.updateEmployee();
				break;
			case 4:
				es.displayAllEmployees();
				break;
			case 5:
				System.out.println("\tTHANK YOU...");
				break;
			default:
				System.out.println("\tWrong Choice!!");
			}
		}while(ch!=5);
		sc.close();
		
		FileOutputStream fos = new FileOutputStream("Emp_data.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(es);
		fos.close();
		
	}
}
