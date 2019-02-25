<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<core:out value="Welcome to JSTL"></core:out> <br>
	<core:set var="name" value="Raju"></core:set> <br>
	Name is <core:out value="${name}"></core:out> <br>

	<core:if test="${10==10}">
		<core:out value="Yes"></core:out>
	</core:if>
	<core:if test="${param.user=='raj' && param.pass=='123'}">
		<core:out value="Successfully logged in..."></core:out>
	</core:if>
	
	<br><br>

	<%
		String[] names = {"raj","seeta","reeta","geeta","ramu"};
		session.setAttribute("names", names);
	%>
	<core:forEach var="n" items="${sessionScope.names}">
		<core:out value="${n}"></core:out><br>
	</core:forEach>

	<br><br>
	
	<sql:setDataSource
		driver="oracle.jdbc.driver.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521/XE"
		user="system"
		password="tiger"
		var="con"
		scope="session"
	/>
	<sql:update dataSource="${sessionScope.con}" sql="insert into emp values(109,'Ajay',19000)" var="temp">
	</sql:update>
	
	<core:if test="${temp gt 0}">
		<core:out value="Record inserted Successfully..."></core:out>
	</core:if>
	
</body>
</html>