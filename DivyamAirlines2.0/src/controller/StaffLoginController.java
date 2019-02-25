package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.StaffService;
import bean.Staff;

/**
 * Servlet implementation class StaffLoginController
 */
public class StaffLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		Staff staff;
		StaffService ss = new StaffService();
		staff = ss.checkStaffLoginService(email, pass);
		
		List<?> listOfFlights = (List<?>)ss.getAllFlightsService();
		HttpSession hs = request.getSession();
		hs.setAttribute("staff",staff);
		hs.setAttribute("listOfFlights", listOfFlights);
		if(staff == null){
			hs.invalidate();
			response.sendRedirect("staffLogin.jsp");
		}else{
			response.sendRedirect("staffIndex.jsp");
		}
	}

}
