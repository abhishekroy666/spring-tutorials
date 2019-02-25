<%@page import="bean.Flight"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style_staffProfile.css">
<script type="text/javascript" src="js/script_revenue.js"></script>
</head>
<body>
	<div id="heading">Revenue Generated</div>
	<div align="center">
		<%!List<?> listOfFlights;%>
		<% 
		listOfFlights = (List<?>)session.getAttribute("listOfFlights");
		if(listOfFlights.isEmpty()){%>
		<div>No Flights to show</div>
		<% }
		if(!listOfFlights.isEmpty()){%>
		<table style="font-size: small;">
			<tr style="border-bottom: 1px solid #ddd;">
				<th>Flight ID</th>
				<th>From</th>
				<th>To</th>
				<th>Departure Time</th>
				<th>Arrival Time</th>
				<th>Seat Capacity</th>
				<th>Price</th>
			</tr>
			<%
        		Iterator<?> itr = listOfFlights.iterator();
        		while(itr.hasNext()){
        			Flight flight = (Flight)itr.next();
        			%>
			<tr>
				<td><%=flight.getFlightId()%></td>
				<td><%=flight.getFromLocation() %></td>
				<td><%=flight.getToLocation()%></td>
				<td><%=flight.getDepartureTime()%></td>
				<td><%=flight.getArrivalTime()%></td>
				<td><%=flight.getNumberOfSeats()%></td>
				<td><%=flight.getPrice()%></td>
			</tr>
			<%
        		}
        	%>
		</table>
		<% }%>
		<form action="StaffRevenueController" method="get" name="f" onsubmit="return validate()">
			<table style="font-size: small;" >
				<tr>
					<td>Enter Flight ID</td>
					<td colspan="2"><input type="text" name="flightid"
						id="flightid" class="textField" required="required"></td>
				</tr>
				<tr>
					<td>From</td>
					<td><input type="date" name="fromdate" id="fromdate"
						class="textField" required="required"></td>
						<td>To</td>
					<td><input type="date" name="todate" id="todate"
						class="textField" required="required"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Get Revenue"
						class="submitButton"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>