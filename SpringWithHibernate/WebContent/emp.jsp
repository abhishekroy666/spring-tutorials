<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spring:form commandName="employee">
		Id:<spring:input path="empId"/><br>
		Name: <spring:input path="empName"/><br>
		Salary: <spring:input path="salary"/><br>
		<input type="submit" value="Submit">
	</spring:form>
</body>
</html>