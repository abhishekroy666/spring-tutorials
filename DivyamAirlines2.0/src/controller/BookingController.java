package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AirlineService;
import bean.Customer;
import bean.Flight;
import bean.FlightDetails;

/**
 * Servlet implementation class BookingController
 */
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AirlineService as = new AirlineService();
		PrintWriter pw = response.getWriter();
		HttpSession hs = request.getSession();
		Customer customer = (Customer)hs.getAttribute("customer");
		FlightDetails flightDetails = (FlightDetails)hs.getAttribute("flightDetails");
		Flight flight = (Flight)hs.getAttribute("flight");
		int numberOfSeats = Integer.parseInt(request.getParameter("numberofseats"));
		List<?> listOfBookings = as.bookFlightService(customer,flightDetails,flight,numberOfSeats);
		System.out.println(flight);
		if(!listOfBookings.isEmpty()){
			hs.setAttribute("bookings",listOfBookings);
			response.sendRedirect("status.jsp");
		}else{
			response.sendRedirect("book.jsp");
			pw.println("Unable to book. Please try again.");
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
