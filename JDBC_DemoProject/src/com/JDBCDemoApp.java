package com;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemoApp 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in); 
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //change JDK & JRE 10 1.7
			System.out.println("\n\tDriver loaded Successfully...");
			
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","system","tiger");
			System.out.println("\n\tEstablished Connection...");
			
			
			//Statement stmt = con.createStatement();
			//System.out.println("\n\tStatement Created...");
			PreparedStatement pstmt = con.prepareStatement("insert into emp values(?,?,?)");
			
			System.out.print("\n\n\tEnter id : "); int id = sc.nextInt();
			System.out.print("\tEnter name : "); String name = sc.next();
			System.out.print("\tEnter salary : "); float sal = sc.nextFloat();
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setFloat(3,sal);
					
			//int result = stmt.executeUpdate("insert into emp values("+id+",'"+name+"',"+sal+")");
			int result = pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("\n\tRecords updated successfully.");
			}
			else
			{
				System.out.println("\n\tRecord not updated.");
			}
			
			/*ResultSet rs = stmt.executeQuery("select * from emp");
			while(rs.next())
			{
				System.out.println();
				System.out.print("\t"+rs.getInt(1));
				System.out.print("\t"+rs.getString(2));
				System.out.print("\t"+rs.getFloat(3));
			}*/
			
			//rs.close();
			pstmt.close();
			con.close();
			sc.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

}
