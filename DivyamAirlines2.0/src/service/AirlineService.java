package service;

import java.util.List;

import dao.AirlineDao;
import bean.Customer;
import bean.Flight;
import bean.FlightDetails;

public class AirlineService {
	
	public Customer checkLoginService(String email, String pass){
		AirlineDao ad = new AirlineDao();
		Customer customer = ad.checkLoginDao(email, pass);
		if(customer.getFirstName()==null){
			return null;
		}
		return customer;
	}
	
	public boolean createCustomerService(Customer customer){
		AirlineDao ad = new AirlineDao();
		return ad.createCustomerDao(customer);	
	}
	
	public boolean updateCustomerService(Customer customer){
		AirlineDao ad = new AirlineDao();
		return ad.updateCustomerDao(customer);
	}
	
	public FlightDetails getFlightDetailsService(int flightDetailsId){
		return new AirlineDao().getFlightDetailsDao(flightDetailsId);
	}
	
	public FlightDetails checkAvailabilityService(String fromLocation,String toLocation, String flightDepartureDate){
		AirlineDao ad = new AirlineDao();
		FlightDetails flightDetails = ad.checkAvailabilityDao(fromLocation, toLocation, flightDepartureDate);
		if(flightDetails.getFlightDetailsId()==0){
			ad.createFlightDetailsDao(flightDepartureDate);
			return ad.checkAvailabilityDao(fromLocation, toLocation, flightDepartureDate);			
		}else{
			return flightDetails;
		}
	}
	
	public Flight getFlightService(int flightId){
		return new AirlineDao().getFlightDao(flightId);
	}
	
	public List<?> bookFlightService(Customer customer,FlightDetails flightDetails, Flight flight, int numberOfSeats){
		AirlineDao ad = new AirlineDao();
		return ad.bookFlightDao(customer,flightDetails,flight,numberOfSeats);
	}
	
	public List<?> getStatusService(Customer customer){
		return new AirlineDao().getStatusDao(customer);
	}
	
	public boolean cancelBookingService(int ticketId){
		return new AirlineDao().cancelBookingDao(ticketId);
	}

}
