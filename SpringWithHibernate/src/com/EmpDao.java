package com;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository("empdao")
public class EmpDao {
	
	@Resource
	SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public void storeEmpDao(Employee emp){
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(emp);
		tran.commit();
	}	
}
