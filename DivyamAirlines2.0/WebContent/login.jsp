<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/style_customerLogin.css">
<script type="text/javascript" src="js/script_login.js"></script>
</head>
<body>

	<form action="LoginController" name="f" method="post"
		onsubmit="return validate()" target="_parent">
		<table style="text-align: center; margin-left: 20%;width:60%;">
			<tr style="font-size: 20px;">
				<td colspan="2">Log In</td>
			</tr>
			<tr style="font-size: 12px;">
				<td>New to Divyam Airline?</td>
				<td><input type="button" value="Register" id="signup"
					onclick="go()"></td>
			</tr>

		</table>

		<table style="font-size: 14px; margin-left: 36%">
			<tr>
				<td>Email ID</td>

			</tr>
			<tr>
				<td><input type="text" name="email" required="required"
					id="email" class="textField"></td>
			</tr>
			<tr>
				<td>Password</td>

			</tr>
			<tr>
				<td><input type="password" name="pass" required="required"
					id="pass" class="textField"></td>
			</tr>
			<tr>
				<td style="text-align: left;"><input type="submit"
					value="Login" id="submit" class="submitButton"></td>
			</tr>
		</table>
	</form>
</body>
</html>