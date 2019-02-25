package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StaffService;

/**
 * Servlet implementation class StaffRevenueController
 */
public class StaffRevenueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffRevenueController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("staffRevenue.jsp");
		int flightId = Integer.parseInt(request.getParameter("flightid"));
		String fromDate = request.getParameter("fromdate");
		String toDate = request.getParameter("todate");
		float revenue = new StaffService().getRevenueService(flightId, fromDate, toDate);
		if(revenue > 0){
			rd.include(request, response);
			response.getWriter().println("Revenue = "+revenue);
		}else{
			rd.include(request, response);
			response.getWriter().println("No revenue for the given dates");
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
