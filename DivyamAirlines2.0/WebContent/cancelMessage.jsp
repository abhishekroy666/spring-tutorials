<%@page import="resource.DateConverter"%>
<%@page import="bean.Booking" %>
<%@page import="bean.FlightDetails" %>
<%@page import="bean.Flight" %>
<%@page import="bean.FlightDetails" %>
<%@page import="service.AirlineService" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style_cancelMessage.css">
</head>
<body>
	<%
		AirlineService as = new AirlineService();
		Booking booking = (Booking)session.getAttribute("booking");
		FlightDetails flightDetails = (FlightDetails)as.getFlightDetailsService(booking.getFlightDetailsId());
		Flight flight = (Flight)as.getFlightService(flightDetails.getFlightId());
		double cancellationCharges = 0.0;
		double refundableAmount = 0.0;
		int days = 0; 
		
		try{
			days = DateConverter.getDays(flightDetails.getFlightDeparturedate());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		if(days>10){
			cancellationCharges = (0.1)*booking.getPrice();
		}else if(days>5){
			cancellationCharges = (0.2)*booking.getPrice();
		}else{
			cancellationCharges = (0.5)*booking.getPrice();
		}
		
		refundableAmount = booking.getPrice()-cancellationCharges;
		
	%>
	<table>
		<tr>
			<td>Booking ID</td>
			<td><%=booking.getTicketId()%></td>
		</tr>
		<tr>
			<td>Journey Date</td>
			<td><%=flightDetails.getFlightDeparturedate()%></td>
		</tr>
		<tr>
			<td>From</td>
			<td><%=flight.getFromLocation()%></td>
		</tr>
		<tr>
			<td>To</td>
			<td><%=flight.getToLocation()%></td>
		</tr>
		<tr>
			<td>Number of Seats</td>
			<td><%=booking.getNumberOfSeats()%></td>
		</tr>
		<tr>
			<td>Total Fare</td>
			<td><%=booking.getPrice()%></td>
		</tr>
		<tr>
			<td>Cancellation Charges</td>
			<td><%=cancellationCharges%></td>
		</tr>
		<tr>
			<td>Refundable Amount</td>
			<td><%=refundableAmount%></td>
		</tr>
	</table>
	<a class="menuTab" href="status.jsp" >Check Status</a>
</body>
</html>