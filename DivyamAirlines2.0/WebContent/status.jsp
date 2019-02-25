<%@page import="resource.DateConverter" %>
<%@page import="bean.FlightDetails" %>
<%@page import="bean.Booking" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<%@page import="service.AirlineService" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style_status.css">
<script type="text/javascript">
	function validate(){
		return confirm("Are you sure you want to cancel this Booking?");		
	}
</script>
</head>
<body>
<div id="heading">
	STATUS
</div>
			<%
			AirlineService as = new AirlineService();
			List<?> listOfBookings = (List<?>)session.getAttribute("bookings");
			if(listOfBookings.isEmpty()){%>
				<div id="noBooking"> You have no Bookings</div>
			<%}
			if(!listOfBookings.isEmpty()){%>
			<table align="center">
				<tr>
					<th>Ticket ID</th>
              		<th>Status</th>
               		<th>Number of Seats Booked</th>
               		<th>Price</th>
            	</tr>
            	<% 
            		Iterator<?> itr = listOfBookings.iterator();
            		while(itr.hasNext()){
            			Booking booking = (Booking)itr.next();
            			String status = booking.getStatus();
            			FlightDetails flightDetails = as.getFlightDetailsService(booking.getFlightDetailsId());
            			if(DateConverter.getDays(flightDetails.getFlightDeparturedate())<0){
            				status = "Expired";
            			}
            	%>
            	<tr>
            		<td><%=booking.getTicketId()%></td>
            		<td><%=status%></td>
            		<td><%=booking.getNumberOfSeats()%></td>
            		<td><%=booking.getPrice()%></td>
            	</tr>
            	<%} %>
            </table >
            <form action="CancelBookingController" name="f" method="get" onsubmit="return validate()" align="center">
				Ticket ID <input type="text" name="tid" placeholder="Enter Ticket ID" class="textField"><br>
				<input type="submit" value="Cancel"  class="submitButton">
			</form>
            <%} %> 
</body>
</html>