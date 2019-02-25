<%@page import="bean.Flight" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!List<?> listOfFlights;%>
	<% 
		listOfFlights = (List<?>)session.getAttribute("listOfFlights");
		if(listOfFlights.isEmpty()){%>
			<div>No Flights to show</div>
		<% }
		if(!listOfFlights.isEmpty()){%>
		<table>
			<tr>
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
	<form action="StaffRevenueController" method="get" name="f">
		<table>
			<tr>
				<td>Enter Flight ID</td>
				<td colspan="2"><input type="text" name="flightid" id="flightid"></td>
			</tr>
			<tr>
				<td>From</td>
				<td><input type="date" name="fromdate" id="fromdate"></td>
				<td><input type="date" name="todate" id="todate"></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Get Revenue"></td>
			</tr>	
		</table>
	</form>
</body>
</html>