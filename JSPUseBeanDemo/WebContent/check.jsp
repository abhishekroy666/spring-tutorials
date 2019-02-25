<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.Login" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!
		String user,pass;
	%>
	<%
		user = request.getParameter("user");
		pass = request.getParameter("pass");
		
		Login ll = new Login();
		ll.setUser(user);
		ll.setPass(pass);
		session.setAttribute("login",ll);
	%>
	
	<jsp:useBean id="ll1" class="com.Login" scope="session"></jsp:useBean>
	<jsp:setProperty property="user" name="ll1" param="user"/>
	<jsp:setProperty property="pass" name="ll1" param="pass"/>
	
	Display the value using Scriptlet tag <br>
	<%
		out.println("Name is : "+ll.getUser()+"<br>");
		out.println("Password is : "+ll.getPass());
	%>
	
	<br><br>
	Display the value using useBean tag<br>
	Username : <jsp:getProperty property="user" name="ll1"/><br>
	Password : <jsp:getProperty property="pass" name="ll1"/>
	
</body>
</html>