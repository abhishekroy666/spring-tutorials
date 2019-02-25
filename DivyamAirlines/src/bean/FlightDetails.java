package bean;

public class FlightDetails {
	private int flightDetailsId;
	private int flightId;
	private String flightDeparturedate;
	private int availableSeats;
	
	public int getFlightDetailsId() {
		return flightDetailsId;
	}
	public void setFlightDetailsId(int flightDetailsId) {
		this.flightDetailsId = flightDetailsId;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightDeparturedate() {
		return flightDeparturedate;
	}
	public void setFlightDeparturedate(String flightDeparturedate) {
		this.flightDeparturedate = flightDeparturedate;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	@Override
	public String toString() {
		return "FlightDetails [flightDetailsId=" + flightDetailsId
				+ ", flightId=" + flightId + ", flightDeparturedate="
				+ flightDeparturedate + ", availableSeats=" + availableSeats
				+ "]";
	}
}
