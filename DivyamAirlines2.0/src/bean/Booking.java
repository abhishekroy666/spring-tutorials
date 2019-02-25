package bean;

import java.io.Serializable;

public class Booking implements Serializable{
	private static final long serialVersionUID = 1L;
	private int ticketId;
	private int customerId;
	private int flightDetailsId;
	private String status;
	private int numberOfSeats;
	private float price;
	
	// setters and getters
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getFlightDetailsId() {
		return flightDetailsId;
	}
	public void setFlightDetailsId(int flightDetailsId) {
		this.flightDetailsId = flightDetailsId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Booking [ticketId=" + ticketId + ", customerId=" + customerId
				+ ", flightDetailsId=" + flightDetailsId + ", status=" + status
				+ ", numberOfSeats=" + numberOfSeats + ", price=" + price + "]";
	}	
}
