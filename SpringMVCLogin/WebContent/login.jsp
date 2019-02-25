<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Login Page</h2>
	<spring:form commandName="login">
		Username<spring:label path="uname"></spring:label><spring:input path="uname"/><br>
		Password<spring:label path="pass"></spring:label><spring:input path="pass"/><br>
		<input type="submit" value="Login">
	</spring:form>	
</body>
</html>