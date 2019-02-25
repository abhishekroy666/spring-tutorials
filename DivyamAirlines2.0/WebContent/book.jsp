<%@page import="bean.FlightDetails" %>
<%@page import="bean.Flight" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/script_book.js"></script>
<link rel="stylesheet" href="css/style_book.css">
</head>
<body>
<div id="heading">
	BOOK ONLINE
</div>
	<div id="input">
		<form action="CheckAvailabilityController" name="f" method="get" onsubmit="return validate1()">
			<table>
				<tr>
					<td>Origin</td>
					<td>  
					    <select name="fromLocation" required="required" class="textField">
							<option>---select city---</option>
							<option value="BLR">Bangalore</option>
							<option value="DEL">Delhi</option>
		                   	<option value="BOM">Mumbai</option>
		                   	<option value="PNQ">Pune</option>
		                 </select>       
					</td>
				</tr>
				<tr>
					<td>Destination</td>
					<td>
                     	<select name="toLocation" required="required"  class="textField">
							<option>---select city---</option>
							<option value="BLR">Bangalore</option>
							<option value="DEL">Delhi</option>
		                   	<option value="BOM">Mumbai</option>
		                   	<option value="PNQ">Pune</option>
		    	       </select>
					</td>
				</tr>
				<tr>
					<td>Departure Date</td>
					<td>
                	    <input type="date" name="flightDeparturedate" required="required" class="textField" >
					</td>
				</tr>
				<tr>
					<td colspan=2>
						<input type="submit" value="Check Availability" id="check" class="submitButton">
					</td>
                   </tr>
			</table>
		</form>
	</div>
	<div id="display">
		<form name="f1" action="BookingController" method="get">
		<%
			FlightDetails flightDetails = (FlightDetails)session.getAttribute("flightDetails");  
			Flight flight = (Flight)session.getAttribute("flight");
			if(flight!= null && flightDetails!=null){%>
			<table id="displayTable">
				<tr>       
					<th>Flight ID</th>
					<th>Origin</th>
              		<th>Destination</th>
               		<th>Departure Time</th>
              		<th>Arrival Time</th>
               		<th>Available Seats</th>
               		<th>Price</th>
            	</tr>
            	<tr>
            		<td><%=flightDetails.getFlightId()%></td>
            		<td><%=flight.getFromLocation()%></td>
            		<td><%=flight.getToLocation()%></td>
            		<td><%=flight.getDepartureTime()%></td>
            		<td><%=flight.getArrivalTime()%></td>
            		<td><%=flightDetails.getAvailableSeats()%></td>
            		<td><%=flight.getPrice()%></td>
            	</tr>
            </table>
            <%} %> 
            <div id="book">
            Number Of Passengers: 
            	<select name="numberofseats" class="textField" style="margin-left: 2%;">
            		<option>1</option>
            		<option>2</option>
            		<option>3</option>
            		<option>4</option>
            	</select>
            	<input type="submit" value="Book" id="book"  class="submitButton"  style="margin-left: 2%;">
            </div>
            </form>    	       
   	</div>
</body>
</html>