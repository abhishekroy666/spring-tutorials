<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! int a,b,sum; %>
<%
	a = 20;
	b = 20;
	sum=a+b;
	out.println("Sum is "+sum);
	out.println("<br>Welcome to JSP");
%>
<br>
Sum of two numbers is <%=sum %>
<h2><font color="green">Hello<%=300+120 %></font></h2>
</body>
</html>