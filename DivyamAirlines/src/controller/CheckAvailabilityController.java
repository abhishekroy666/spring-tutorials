package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AirlineService;
import bean.Flight;
import bean.FlightDetails;

/**
 * Servlet implementation class CheckAvailabilityController
 */
public class CheckAvailabilityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAvailabilityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fromLocation = request.getParameter("fromLocation");
		String toLocation = request.getParameter("toLocation");
		String flightDeparturedate = request.getParameter("flightDeparturedate");
		
		FlightDetails flightDetails = new FlightDetails();
		Flight flight = new Flight();
		
		AirlineService as = new AirlineService();
		flightDetails = as.checkAvailabilityService(fromLocation,toLocation,flightDeparturedate);
		flight = as.getFlightService(flightDetails.getFlightId());
		HttpSession hs = request.getSession();
		hs.setAttribute("flightDetails",flightDetails);
		hs.setAttribute("flight",flight);
		System.out.println(flight);
		response.sendRedirect("book.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
