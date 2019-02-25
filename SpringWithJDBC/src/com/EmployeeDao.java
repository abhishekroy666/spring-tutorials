package com;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("empdao")
public class EmployeeDao {

	@Autowired
	private DataSource ds;

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	public void storeEmp(Employee emp){
		try {
			Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?)");
			ps.setInt(1,emp.getId());
			ps.setString(2,emp.getName());
			ps.setFloat(3,emp.getSalary());
			
			if(ps.executeUpdate()>0){
				System.out.println("Record successfully inserted");
			}
			ps.close();
			con.close();			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
