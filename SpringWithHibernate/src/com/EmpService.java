package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("empservice")
public class EmpService {

	@Autowired
	EmpDao empdao;
	
	public void storeEmpService(Employee emp){
		System.out.println("Service layer called");
		empdao.storeEmpDao(emp);
	}
}
