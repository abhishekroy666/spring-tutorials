<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	table,td,tr,th{
		font-family:monospace;
	}
</style>
</head>
<body>
	<div id="header" style="width:100%" >
		<div id="logo" style="display: inline-block;">
			<img src="img\logo.png" style="height: 100px;" >
		</div>
		
		<div id="menuButton" style="display: inline-block;">
			<table id="indexTab">
				<tr>
					<td>
					<a href="login.jsp" target="main1" class="menuTab" id="customerTab">Customer Login</a>
					</td>
					<td><a href="staffLogin.jsp" target="main1" class="menuTab" id="staffTab">Staff Login</a></td>
					<td><a href="reg.jsp" target="main1" class="menuTab" id="registrationTab">Register</a></td>

					<td><input type="button" value="About" id="aboutTab"
						class="menuTab"></td>
					<td><a href="contact.jsp" target="main1" class="menuTab" id="contactTab">Contact</a></td>
				</tr>

			</table>
		</div>
	</div>
</body>
</html>