package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import resource.DBConnection;
import bean.Emp;

public class EmpDao {
	public int createEmpDao(Emp emp){
		try{
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into emp values(?,?,?)");
			pstmt.setInt(1,emp.getEmpId());
			pstmt.setString(2,emp.getEmpName());
			pstmt.setFloat(3,emp.getSalary());
			
			int result = pstmt.executeUpdate();
			return result;
		}catch(Exception e){
			System.out.println("Create Emp DAO "+e);
		}
		return 0;
	}
	
	public List<Emp> retrieveEmpDao(){
		List<Emp> listOfRecords = new ArrayList<Emp>();
		try{
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("Select * from emp");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Emp emp = new Emp();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setSalary(rs.getFloat(3));
				listOfRecords.add(emp);
			}			
		}catch(Exception e){
			System.out.println("Retrieve EMP DAO "+e);
		}
		return listOfRecords;
	}
}
