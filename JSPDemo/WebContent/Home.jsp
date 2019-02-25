<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome to Home Page</h2>
<%@ page errorPage="error.jsp" %>
<%!
	String user,pass;
	int age;
%>
<%
	user = request.getParameter("uname");
	pass = request.getParameter("pass");
	age = Integer.parseInt(request.getParameter("age"));
	out.println("Username = "+user+" Password ="+pass+" Age="+age);
%>
</body>
</html>