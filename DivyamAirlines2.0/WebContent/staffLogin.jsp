<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style_staffLogin.css">
</head>
<body>
	<form action="StaffLoginController" name="f" method="post"
		onsubmit="return validate()" target="_parent">

		<table style="text-align: center;">

			<tr style="font-size: 20px;">
				<td>Staff Log In</td>
			</tr>
			<tr style="font-size: 12px;">
				<td>Great minds have purposes, others have wishes!</td>

			</tr>

		</table>

		<table style="font-size: 15px;margin-left: 36%;">
			<tr>
				<td>Staff Email ID</td>

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