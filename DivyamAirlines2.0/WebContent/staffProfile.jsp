<%@page import="bean.Staff"%>
<%@page import="resource.DateConverter"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style_staffProfile.css">
<script type="text/javascript" src="js/script_profile.js"></script>
</head>
<body>
	<%!Staff staff;%>
	<%
		staff = (Staff) session.getAttribute("staff");
	%>
	<div id="heading">Staff Profile</div>
	<div style="display: inline-block" id="profileBody">
		<form action="UpdateStaffController" name='f' method="get">
			<table>
				<tr>
					<td>Staff ID</td>
					<td><%=staff.getStaffId()%></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="fname"
						value="<%=staff.getFirstName()%>" required="required"
						class="textField"> <input type="text" name="lname"
						value="<%=staff.getLastName()%>" required="required"
						class="textField"></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><%=staff.getGender()%></td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><input type="date" name="dob"
						value="<%=DateConverter.getDate(staff.getDob())%>"
						contenteditable="true" checked="checked" class="textField">
					</td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="add"
						value="<%=staff.getAddress()%>" required="required"
						class="textField"></td>
				</tr>
				<tr>
					<td>Telephone number</td>
					<td><input type="number" name="tel"
						value="<%=staff.getTelephoneNumber()%>" required="required"
						class="textField"></td>
				</tr>
				<tr>
					<td>E-mail ID</td>
					<td><%=staff.getEmailId()%></td>
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