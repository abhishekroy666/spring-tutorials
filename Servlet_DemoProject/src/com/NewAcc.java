package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.DBConnection;

/**
 * Servlet implementation class NewAcc
 */
public class NewAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String query;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAcc() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig con) throws ServletException {
    	query = con.getInitParameter("query");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int accno = Integer.parseInt(request.getParameter("accno"));
		String name = request.getParameter("n");
		float amt = Float.parseFloat(request.getParameter("amt"));
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		PrintWriter pw = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		try{
			Connection con = DBConnection.getDBConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,accno);
			ps.setString(2,name);
			ps.setFloat(3,amt);
			ps.setString(4,user);
			ps.setString(5,pass);
			
			int rs = ps.executeUpdate();
			
			if(rs>0){
				pw.println("Account Successfully created");
				rd.include(request, response);
			}
			con.close();
			ps.close();
		}catch(Exception e)
		{
			pw.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
