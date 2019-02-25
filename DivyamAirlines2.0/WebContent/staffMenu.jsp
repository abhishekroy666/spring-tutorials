<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style_staffMenu.css">

</head>
<body>
	<div id="menu" style="width: 100%;">
		<div id="logo" style="display: inline-block;">
			<img src="img\logo.png" style="height: 100px;">
		</div>

		<div id="menuButton" style="display: inline-block;">

			<table>
				<tr>
					<td><a href="staffProfile.jsp" target="main" class="menuTab">Profile</a></td>
					<td><a href="staffRevenue.jsp" target="main" class="menuTab">View Revenue Details</a></td>
					<td> <a href="index.jsp" class="menuTab">Logout</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>