<%@page import="bean.Customer"%>
<%@page import="resource.DateConverter"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style_profile.css">
<script type="text/javascript" src="js/script_profile.js"></script>
</head>
<body>
	<%!Customer customer; %>
	<%
		customer = (Customer)session.getAttribute("customer");
	%>
	<div id="heading">
	PROFILE
</div>
	<div id="profileBody">
		<form action="UpdateCustomerController" name='f' method="get">
			<table>
				<tr>
					<td>Customer ID</td>
					<td><%=customer.getCustomerId()%></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="fname"
						value="<%=customer.getFirstName()%>" required="required"
						class="textField"> <input type="text" name="lname"
						value="<%=customer.getLastName()%>" required="required"
						class="textField"></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><%=customer.getGender()%></td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><input type="date" name="dob"
						value="<%=DateConverter.getDate(customer.getDob())%>"
						contenteditable="true" checked="checked" class="textField">
					</td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="add"
						value="<%=customer.getAddress()%>" required="required"
						class="textField"></td>
				</tr>
				<tr>
					<td>Telephone number</td>
					<td><input type="number" name="tel"
						value="<%=customer.getTelephoneNumber()%>" required="required"
						class="textField"></td>
				</tr>
				<tr>
					<td>E-mail ID</td>
					<td><%=customer.getEmailId()%></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update Profile" id="edit"
						class="submitButton"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>