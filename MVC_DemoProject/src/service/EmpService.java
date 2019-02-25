package service;

import java.util.List;

import dao.EmpDao;
import bean.Emp;

public class EmpService {

	public int createEmpService(Emp emp){
		EmpDao ed = new EmpDao();
		if(emp.getSalary()>12000){
			return ed.createEmpDao(emp);
		}else{
			return 0;
		}
	}
	
	public List<Emp> retrieveEmpService(){
		EmpDao ed = new EmpDao();
		List<Emp> listOfRecords = ed.retrieveEmpDao();
		return listOfRecords;
	}
}
