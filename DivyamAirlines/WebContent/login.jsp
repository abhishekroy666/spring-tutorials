<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" href="css/style_login.css">
	<script type="text/javascript" src="js/script_login.js"></script>
</head>
<body>

	<div id="header">
	</div>
        
    <div style="display:inline-block" id="body">
    	<div id="desc">
     		Divyam Airline is a newly opened airline company. It provides air transport services for traveling passengers for domestic flights. Currently Divyam Airline is using a manual system for ticket reservation, ticket cancellation, changing the status of the tickets, giving information to the passengers about the tickets. The manual system was working fine when it was dealing less number of passengers. 
     	</div>
        <div style="display:inline-block" id="login">
        	<form action="LoginController" name="f" method="post" onsubmit="return validate()">
            	<table>
                	<tr>
                   		<td>Email ID</td>
                       	<td><input class="text" type="text" name="email" placeholder="Enter email ID" required="required"></td>
                   	</tr>
                    <tr>
                        <td>Password</td>
                        <td><input class="text"  type="password" name="pass" placeholder="Enter Password" required="required"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" id="submit"></td>
                        <td><input type="button" value="New User" id="signup" onclick="go()"></td>
                    </tr>
	              </table>
    	    </form>
        </div>
 	</div>
        
    <div id="footer">
    </div>
            
</body>
</html>