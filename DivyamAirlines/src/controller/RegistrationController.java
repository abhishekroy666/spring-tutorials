package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AirlineService;
import bean.Customer;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		HttpSession hs = request.getSession();
		customer.setFirstName(request.getParameter("fname"));
		customer.setLastName(request.getParameter("lname"));
		customer.setGender(request.getParameter("gender"));
		customer.setDob(request.getParameter("dob"));
		customer.setAddress(request.getParameter("add"));
		customer.setTelephoneNumber(request.getParameter("tel"));
		customer.setEmailId(request.getParameter("email"));
		customer.setPassword(request.getParameter("pass"));
		AirlineService as = new AirlineService();
		if(as.createCustomerService(customer)){
			hs.setAttribute("customer",customer);
			response.sendRedirect("login.jsp");
		}else{
			response.sendRedirect("reg.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
