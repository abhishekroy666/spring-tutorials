package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import resource.DBConnection;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String query;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    ServletContext sc;
    public void init(ServletConfig con) throws ServletException {
    	super.init(con);
		sc = con.getServletContext();
    	query = con.getInitParameter("query");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//RequestDispatcher rd1 = request.getRequestDispatcher("Home");
		//RequestDispatcher rd2 = request.getRequestDispatcher("login.html");
		PrintWriter pw = response.getWriter();
		HttpSession hs = request.getSession();
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String nme = "";
		int flag = 0;
		try{
			Connection con = DBConnection.getDBConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String un = rs.getString(4);
				String pas = rs.getString(5);
				nme = rs.getString(2);
				if(uname.equals(un)&&pass.equals(pas)){
					flag = 1;
					//request.setAttribute("name",nme);
					hs.setAttribute("name",nme);
					sc.setAttribute("name", nme);
					break;
				}
			}
			con.close();
			rs.close();
			ps.close();
		}catch(Exception e)
		{
			
		}
		if(flag == 0){
			pw.println("Invalid credentials...");
			response.sendRedirect("login.html");
			//rd2.include(request,response);
		}
		else{
			//rd1.include(request, response);
			response.sendRedirect("Home");
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
