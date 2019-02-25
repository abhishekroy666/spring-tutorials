<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="bean.Emp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<h2>Create Employee</h2>
	<form action="EmpController" method="post">
		ID <input type="text" name="empid"><br>
		Name <input type="text" name="empname"><br>
		Salary <input type="text" name="salary"><br>
		<input type="submit" value="Create Employee Details">
	</form>
	<br>
	<br>
	<h1>Display Employee Information using Scriplet tag</h1>
	<table border="1">
		<caption>Employee Details</caption>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Salary</th>
		</tr>
		<%
			Object obj = session.getAttribute("records");
			if(obj!=null){
				List<?> listOfRecords=(List<?>)obj;
				ListIterator<?> li = listOfRecords.listIterator();
				while(li.hasNext()){
					Emp emp = (Emp)li.next();
					%>
					<tr>
						<td><%=emp.getEmpId()%></td>
						<td><%=emp.getEmpName()%></td>
						<td><%=emp.getSalary()%></td>
					</tr>
					<%
				}
			}
		%>
	</table>
	<br><br>
	<h1>Display Employee Information using JSTL tags</h1>
	<table	border="1">
		<caption>Employee Details</caption>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Salary</th>
		</tr>
		<core:forEach var="emp" items="${sessionScope.records}">
			<tr>
				<td><core:out value="${emp.getEmpId()}"></core:out></td>
				<td><core:out value="${emp.getEmpName()}"></core:out></td>
				<td><core:out value="${emp.getSalary()}"></core:out></td>
			</tr>
		</core:forEach>
	</table>
	
		
</body>
</html>