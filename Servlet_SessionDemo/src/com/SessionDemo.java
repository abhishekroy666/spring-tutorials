package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo
 */
public class SessionDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    int count = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		HttpSession hs = request.getSession();
		if(hs.isNew())
			pw.println("<br>New Client");
		else
			pw.println("<br>Old Client");
		
		pw.println("<br>Session ID : "+hs.getId());
		pw.println("<br>Session Creation Time : "+new Date(hs.getCreationTime()));
		pw.println("<br>Last Access Time : "+new Date(hs.getLastAccessedTime()));
		pw.println("<br>Default time of Session : "+hs.getMaxInactiveInterval());
		hs.setMaxInactiveInterval(600);
		pw.println("<br>Custom time of session : "+hs.getMaxInactiveInterval());
		count++;
		pw.println("<br>Count value is : "+count);
		if(count%5==0)
			hs.invalidate();
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
