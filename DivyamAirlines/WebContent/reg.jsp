<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/style_reg.css">
	<script type="text/javascript" src="js/script_reg.js"></script>
	<title>New User Registration</title>
</head>
<body>
	<div id="header">
	</div>
     
    <div  id="body">
    	<h2>New Customer Registration</h2>
        <form action="RegistrationController" name="f" onsubmit="return validate()" method="get">
        	<table>
            	<tr>
                	<td>First Name</td>
                    <td><input type="text" name="fname" placeholder="First Name" required="required"></td>
             	</tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lname" placeholder="Last Name" required="required"></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                	    <input type="radio" name="gender" value="male" checked>Male
                    	<input type="radio" name="gender" value="female">Female  
                   	</td>
                </tr>
                <tr>
                    <td>Date of Birth</td>
                    <td><input type="date" name="dob"></td>
               	</tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="add" placeholder="Address" required="required"></td>
                </tr>
                <tr>
                    <td>Telephone Number</td>
                	<td><input type="number" name="tel" placeholder="XXXXXXXXXX" required="required"></td>
              	</tr>
                <tr>
                	<td>Email</td>
                    <td><input type="email" name="email" placeholder="xyz@abc.com" required="required"></td>
           		</tr>
                <tr>
                	<td>Password</td>
                    <td><input type="password" name="pass" placeholder="Enter Password" required="required"></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="cpass" placeholder="Re-enter Password" required="required"></td>
                </tr> 
                <tr>
                	<td colspan="2"><input type="submit" value="Register" id="register"></td>
                </tr>
        	</table>
       	</form>
 	</div>
            
    <div id="footer">
    </div>
            
</body>
</html>