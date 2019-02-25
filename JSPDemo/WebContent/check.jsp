<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!String user,pass; %>
	<%
		user = request.getParameter("uname");
		pass = request.getParameter("pass");
		//RequestDispatcher rd1 = request.getRequestDispatcher("Home.jsp");
		//RequestDispatcher rd2 = request.getRequestDispatcher("login.jsp");
		if(user.equals("raj") && pass.equals("123")){
			//rd1.forward(request,response);
			%>
			<jsp:forward page="Home.jsp"></jsp:forward>
			<%
		}else{
			out.println("Invalid Credentials");
			%>
			<jsp:include page="login.jsp"></jsp:include>
			<%
			//rd2.include(request,response);
		}		
	%>
</body>
</html>