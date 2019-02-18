<%@page import="com.user.MyUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.msg.MyMessage"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to our website!!</h2>
	<%
		MyUser user = (MyUser)session.getAttribute("currentUser");
		MyUser ub = (MyUser)session.getAttribute("uBean");
		MyMessage msg = (MyMessage)request.getAttribute("message");
		String message = msg.getMessage();
	%>
	<%
		String userName = user.getUserName();
		String currUser = ub.getUserName();
	%>
	<%=message %><br/>
	Current User: <%=userName %><br/>
	Current User: <%=currUser %><br/>
</body>
</html>