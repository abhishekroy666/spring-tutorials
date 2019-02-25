package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import resource.DBConnection;
import resource.DateConverter;
import bean.Flight;
import bean.Staff;

public class StaffDao {

	public Staff checkStaffLoginDao(String email,String pass){
		Staff staff = new Staff();
		try{
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("Select * from staff where email like ? and password like ?");
			pstmt.setString(1, email);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				staff.setStaffId(rs.getInt(1));
				staff.setFirstName(rs.getString(2));
				staff.setLastName(rs.getString(3));
				staff.setGender(rs.getString(4));
				staff.setDob(rs.getString(5));
				staff.setAddress(rs.getString(6));
				staff.setTelephoneNumber(rs.getString(7));
				staff.setEmailId(rs.getString(8));
				staff.setPassword(rs.getString(9));
			}
			con.close();
			pstmt.close();
			rs.close();
		}catch(Exception e){
			System.out.println("Staff Login DAO "+e.getMessage());
		}
		return staff;
	}
	
	public boolean updateStaffDao(Staff staff){
		try{
			Connection con = DBConnection.getConnection();
			String query = "update staff set firstname=?,lastname=?,dob=?,address=?,telephonenumber=? where staffid=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,staff.getFirstName());
			pstmt.setString(2,staff.getLastName());
			//pstmt.setString(3,customer.getGender());
			pstmt.setDate(3,DateConverter.getDate(staff.getDob()));
			pstmt.setString(4,staff.getAddress());
			pstmt.setString(5,staff.getTelephoneNumber());
			//pstmt.setString(7,customer.getEmailId());
			//pstmt.setString(8,customer.getPassword());
			pstmt.setInt(6,staff.getStaffId());
			int res = pstmt.executeUpdate();
			con.close();
			pstmt.close();
			if(res>0){
				return true;
			}			
		}catch(Exception e){
			System.out.println("Update Staff DAO "+e.getMessage());
		}
		return false;
	}
	
	public List<?> getAllFlightsDao(){
		List<Flight> listOfFlights = new ArrayList<Flight>();
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from flight");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Flight flight = new Flight();
				flight.setFlightId(rs.getInt(1));
				flight.setFromLocation(rs.getString(2));
				flight.setToLocation(rs.getString(3));
				flight.setDepartureTime(rs.getString(4));
				flight.setArrivalTime(rs.getString(5));
				flight.setNumberOfSeats(rs.getInt(6));
				flight.setPrice(rs.getFloat(7));
				
				listOfFlights.add(flight);
			}
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Get All Flights DAO "+e.getMessage());
		}
		return listOfFlights;
	}
	
	public float getRevenueDao(int flightId, String fromDate, String toDate){
		float revenue = 0.0f;
		try {
			String query = "select b.price from booking b,  flightdetails fd where b.flightdetailsid = fd.flightdetailsid and fd.flightid = ? and (fd.flightdeparturedate between ? and ?)";
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,flightId);
			pstmt.setDate(2,DateConverter.getDate(fromDate));
			pstmt.setDate(3,DateConverter.getDate(toDate));
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				revenue += rs.getFloat(1);				
			}
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Revenue DAO "+e.getMessage());
		}
		return revenue;
	}
}
