<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check</title>
</head>
<body>
<%@ page import="bean.Login" %>
<%! String uname,pass;%>
<%
	uname = request.getParameter("uname");
	pass = request.getParameter("pass");
	Login ll = new Login();
	ll.setUname(uname);
	ll.setPass(pass);
	if(ll.checkUser()){
		%>
		<jsp:forward page="home.jsp"></jsp:forward>
		<%
	}else{
		%>
		<jsp:include page="login.jsp"></jsp:include>
		<%
	}
%>
</body>
</html>