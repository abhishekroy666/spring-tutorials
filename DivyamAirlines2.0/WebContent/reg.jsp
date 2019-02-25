<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/script_reg.js"></script>
<title>New User Registration</title>
<link rel="stylesheet" href="css/style_reg.css">
</head>
<body>
	<div id="body" >

		<form action="RegistrationController" name="f"
			onsubmit="return validate()" method="get" target="_parent">
			<table style="font-size:12px;">
				<tr style="font-size: medium; text-align: center;">
				<td colspan="2">Register</td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="fname" placeholder="First Name"
						required="required" class="textField"></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lname" placeholder="Last Name"
						required="required" class="textField"></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="radio" name="gender" value="male" checked>Male
						<input type="radio" name="gender" value="female">Female</td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><input type="date" name="dob" class="textField"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="add" placeholder="Address"
						required="required" class="textField"></td>
				</tr>
				<tr>
					<td>Telephone Number</td>
					<td><input type="number" name="tel" placeholder="XXXXXXXXXX"
						required="required" class="textField"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" placeholder="xyz@abc.com"
						required="required" class="textField"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pass"
						placeholder="Enter Password" required="required" class="textField"></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="cpass"
						placeholder="Re-enter Password" required="required"
						class="textField"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Register"
						id="register" style="text-align: center;" class="submitButton"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>