<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!
		int a,b,sum;
	%>
	<%
		a=10; b=20;
		sum=a+b;
		out.println("Sum is "+sum);
	%>
	<br>
	Sum of two numbers : <%= a+b %>
	<br>
	Sum of two numbers : ${10+20} or ${a+b}<br>
	Sub : ${20-10}<br>
	Mul : ${20*2}<br>
	Div ${20/10}<br>
	Equals ${10==20} or ${10 eq 20}<br>
	Greater than ${20>10} or ${20 gt 10}<br>
	
	<br>Using Scriptlet tag	<br>
	<% 	session.setAttribute("obj","Raj");
		out.println("Name is : "+session.getAttribute("obj"));
	%>
	<br>Using EL<br>
	Name is : ${sessionScope.obj}
</body>
</html>