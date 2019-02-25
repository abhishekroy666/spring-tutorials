package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.StaffService;
import bean.Staff;

/**
 * Servlet implementation class UpdateStaffController
 */
public class UpdateStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStaffController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs = request.getSession();
		Staff staff = (Staff)hs.getAttribute("staff");
		staff.setFirstName(request.getParameter("fname"));
		staff.setLastName(request.getParameter("lname"));
		//customer.setGender(request.getParameter("gender"));
		staff.setDob(request.getParameter("dob"));
		staff.setAddress(request.getParameter("add"));
		staff.setTelephoneNumber(request.getParameter("tel"));
		//customer.setEmailId(request.getParameter("email"));
		//customer.setPassword(request.getParameter("pass"));
		
		StaffService ss = new StaffService();
		if(ss.updateStaffService(staff)){
			hs.setAttribute("staff",staff);
			response.sendRedirect("staffProfile.jsp");
		}else{
			response.sendRedirect("staffProfile.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
