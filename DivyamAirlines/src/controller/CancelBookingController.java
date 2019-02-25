package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Booking;
import service.AirlineService;

/**
 * Servlet implementation class CancelBookingController
 */
public class CancelBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelBookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AirlineService as = new AirlineService();
		int ticketId = Integer.parseInt(request.getParameter("tid"));
		if(as.cancelBookingService(ticketId)){
			HttpSession hs = request.getSession();
			List<?> listOfBookings = (List<?>)hs.getAttribute("bookings");
			Iterator<?> itr = listOfBookings.iterator();
			while(itr.hasNext()){
				Booking booking = (Booking)itr.next();
				if(booking.getTicketId()==ticketId){
					listOfBookings.remove(booking);
				}
			}
			hs.setAttribute("bookings",listOfBookings);
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
