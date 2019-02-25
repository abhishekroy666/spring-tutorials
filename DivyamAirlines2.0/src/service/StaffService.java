package service;

import java.util.List;

import bean.Staff;
import dao.StaffDao;

public class StaffService {

	public Staff checkStaffLoginService(String email, String pass){
		Staff staff = new StaffDao().checkStaffLoginDao(email, pass);
		if(staff.getFirstName()==null){
			return null;
		}
		return staff;
	}
	
	public boolean updateStaffService(Staff staff){
		return new StaffDao().updateStaffDao(staff);
	}
	
	public List<?> getAllFlightsService(){
		StaffDao sd = new StaffDao();
		List<?> listOfFlights = (List<?>)sd.getAllFlightsDao();
		return listOfFlights;		
	}
	
	public float getRevenueService(int flightId, String fromDate, String toDate){
		return new StaffDao().getRevenueDao(flightId, fromDate, toDate);
	}
}
