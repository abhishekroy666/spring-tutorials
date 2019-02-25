package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import resource.DBConnection;
import resource.DateConverter;
import bean.Booking;
import bean.Customer;
import bean.Flight;
import bean.FlightDetails;

public class AirlineDao {

	public Customer checkLoginDao(String email,String pass){
		Customer customer = new Customer();
		try{
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("Select * from customer where email like ? and password like ?");
			pstmt.setString(1, email);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				customer.setCustomerId(rs.getInt(1));
				customer.setFirstName(rs.getString(2));
				customer.setLastName(rs.getString(3));
				customer.setGender(rs.getString(4));
				customer.setDob(rs.getString(5));
				customer.setAddress(rs.getString(6));
				customer.setTelephoneNumber(rs.getString(7));
				customer.setEmailId(rs.getString(8));
				customer.setPassword(rs.getString(9));
			}
			con.close();
			pstmt.close();
			rs.close();
		}catch(Exception e){
			System.out.println("Login DAO "+e.getMessage());
		}
		return customer;
	}
	
	public boolean createCustomerDao(Customer customer){
		try{
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into customer values(cid.nextval,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,customer.getFirstName());
			pstmt.setString(2,customer.getLastName());
			pstmt.setString(3,customer.getGender());
			pstmt.setDate(4,DateConverter.getDate(customer.getDob()));
			pstmt.setString(5,customer.getAddress());
			pstmt.setString(6,customer.getTelephoneNumber());
			pstmt.setString(7,customer.getEmailId());
			pstmt.setString(8,customer.getPassword());
			int res = pstmt.executeUpdate();
			con.close();
			pstmt.close();
			if(res>0){
				return true;
			}
		}catch(Exception e){
			System.out.println("Create Customer DAO "+e.getMessage());
		}
		return false;
	}
	
	public boolean updateCustomerDao(Customer customer){
		try{
			Connection con = DBConnection.getConnection();
			String query = "update customer set firstname=?,lastname=?,dateofbirth=?,address=?,telephonenumber=? where customerid=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,customer.getFirstName());
			pstmt.setString(2,customer.getLastName());
			//pstmt.setString(3,customer.getGender());
			pstmt.setDate(3,DateConverter.getDate(customer.getDob()));
			pstmt.setString(4,customer.getAddress());
			pstmt.setString(5,customer.getTelephoneNumber());
			//pstmt.setString(7,customer.getEmailId());
			//pstmt.setString(8,customer.getPassword());
			pstmt.setInt(6,customer.getCustomerId());
			int res = pstmt.executeUpdate();
			con.close();
			pstmt.close();
			if(res>0){
				return true;
			}			
		}catch(Exception e){
			System.out.println("Update Customer DAO "+e.getMessage());
		}
		return false;
	}
	
	public FlightDetails getFlightDetailsDao(int flightDetailsId){
		FlightDetails flightDetails = new FlightDetails();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from flightdetails where flightdetailsid=?");
			ps.setInt(1,flightDetailsId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				flightDetails.setFlightDetailsId(flightDetailsId);
				flightDetails.setFlightId(rs.getInt(2));
				flightDetails.setFlightDeparturedate(rs.getString(3));
				flightDetails.setAvailableSeats(rs.getInt(4));
			}
		} catch (Exception e) {
			System.out.println("Get FlightDetails DAO "+e.getMessage());
		}
		return flightDetails;
	}
	
	public FlightDetails checkAvailabilityDao(String fromLocation,String toLocation,String flightDeparturedate){
		FlightDetails fd = new FlightDetails();
		try{
			Connection con = DBConnection.getConnection();
			String query = "select fd.flightdetailsid, fd.flightid, fd.flightdeparturedate, fd.availableseats, f.fromlocation, f.tolocation from flightdetails fd, flight f where fd.flightid = f.flightid and flightdeparturedate like ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setDate(1,DateConverter.getDate(flightDeparturedate));
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				if(rs.getString(5).equals(fromLocation) && rs.getString(6).equals(toLocation)){
					fd.setFlightDetailsId(rs.getInt(1));
					fd.setFlightId(rs.getInt(2));
					fd.setFlightDeparturedate(rs.getString(3));
					fd.setAvailableSeats(rs.getInt(4));
				}
			}
			con.close();
			pstmt.close();
			rs.close();
		}catch(Exception e){
			System.out.println("FlightId DAO "+e);
		}
		return fd;
	}
	
	public void createFlightDetailsDao(String flightDepartureDate){
		try{
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt1 = con.prepareStatement("Select * from flight");
			ResultSet rs = pstmt1.executeQuery();
			while(rs.next()){
				String query = "insert into flightdetails values(fdid.nextval,?,?,?)";
				PreparedStatement pstmt2 = con.prepareStatement(query);
				pstmt2.setInt(1,rs.getInt(1));
				pstmt2.setDate(2,DateConverter.getDate(flightDepartureDate));
				pstmt2.setInt(3,rs.getInt(6));	
				pstmt2.executeUpdate();
				pstmt2.close();
			}
			pstmt1.close();
			rs.close();
			con.close();
		}catch(Exception e){
			System.out.println("Create Flight Details DAO "+e.getMessage());
		}
	}
	
	public Flight getFlightDao(int flightId){
		Flight flight = new Flight();
		try{
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("Select * from flight");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int fId = rs.getInt(1);
				if(fId == flightId){
					flight.setFlightId(rs.getInt(1));
					flight.setFromLocation(rs.getString(2));
					flight.setToLocation(rs.getString(3));
					flight.setDepartureTime(rs.getString(4));
					flight.setArrivalTime(rs.getString(5));
					flight.setNumberOfSeats(rs.getInt(6));
					flight.setPrice(rs.getFloat(7));
				}
			}
		}catch(Exception e){
			System.out.println("Get All Flights DAO "+e.getMessage());
		}
		return flight;
	}
	
	public List<?> bookFlightDao(Customer customer,FlightDetails flightDetails, Flight flight,int numberOfSeats){
		List<Booking> listOfBookings = new ArrayList<Booking>();
		try{
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into booking values(bid.nextval,?,?,?,?,?)");
			pstmt.setInt(1,customer.getCustomerId());
			pstmt.setInt(2,flightDetails.getFlightDetailsId());
			pstmt.setString(3,"Active");
			pstmt.setInt(4,numberOfSeats);
			pstmt.setFloat(5,numberOfSeats*flight.getPrice());
			
			int res = pstmt.executeUpdate();
			if(res>0){
				pstmt = con.prepareStatement("select * from booking where custid=?");
				pstmt.setInt(1,customer.getCustomerId());
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					Booking booking = new Booking();
					booking.setTicketId(rs.getInt(1));
					booking.setCustomerId(rs.getInt(2));
					booking.setFlightDetailsId(rs.getInt(3));
					booking.setStatus(rs.getString(4));
					booking.setNumberOfSeats(rs.getInt(5));
					booking.setPrice(rs.getFloat(6));
					listOfBookings.add(booking);
					modifyFlightDetails(flightDetails.getFlightDetailsId(), numberOfSeats);
				}
				rs.close();
			}
			con.close();
			pstmt.close();
		}catch(Exception e){
			System.out.println("Booking "+e.getMessage());
		}
		return listOfBookings;
	}
	
	public List<?> getStatusDao(Customer customer){
		List<Booking> listOfBookings = new ArrayList<Booking>();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from booking where custid=?");
			pstmt.setInt(1,customer.getCustomerId());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Booking booking = new Booking();
				booking.setTicketId(rs.getInt(1));
				booking.setCustomerId(rs.getInt(2));
				booking.setFlightDetailsId(rs.getInt(3));
				booking.setStatus(rs.getString(4));
				booking.setNumberOfSeats(rs.getInt(5));
				booking.setPrice(rs.getFloat(6));
				listOfBookings.add(booking);
			}
			rs.close();
			con.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("Get Status DAO"+e.getMessage());
		}
		return listOfBookings;
	}
	
	public void modifyFlightDetails(int flightDetailsId,int numberOfSeats){
		String query = "update flightdetails set availableseats = availableseats-? where flightdetailsid=?";
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,numberOfSeats);
			pstmt.setInt(2,flightDetailsId);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Modify FlightDetails "+e.getMessage());
		}
	}
	
	public boolean cancelBookingDao(int ticketId){
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from booking where ticketid = ?");
			pstmt.setInt(1,ticketId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				int flightDetailsId = rs.getInt(3);
				int numberOfSeats = rs.getInt(5);				
				modifyFlightDetails(flightDetailsId, -numberOfSeats);
				pstmt = con.prepareStatement("delete from booking where ticketid = ?");
				pstmt.setInt(1,ticketId);
				pstmt.executeUpdate();
				pstmt.close();
				con.close();
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
