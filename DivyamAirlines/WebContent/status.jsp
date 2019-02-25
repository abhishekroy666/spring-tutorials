<%@page import="bean.Booking" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Iterator" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validate(){
		return confirm("Are you sure you want to cancel this Booking?");		
	}
</script>
</head>
<body>
			<%
			List<?> listOfBookings = (List<?>)session.getAttribute("bookings");
			if(listOfBookings.isEmpty()){%>
				<div> You have no Bookings</div>
			<%}
			if(!listOfBookings.isEmpty()){%>
			<table>
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
            	%>
            	<tr>
            		<td><%=booking.getTicketId()%></td>
            		<td><%=booking.getStatus()%></td>
            		<td><%=booking.getNumberOfSeats()%></td>
            		<td><%=booking.getPrice()%></td>
            	</tr>
            	<%} %>
            </table>
            <form action="CancelBookingController" name="f" method="get" onsubmit="return validate()">
				Ticket ID <input type="text" name="tid" placeholder="Enter Ticket ID"><br>
				<input type="submit" value="Cancel">
			</form>
            <%} %> 
</body>
</html>