package Event_Ticket_Booking_System;

@SuppressWarnings("serial")
public class InvalidBookingException extends Exception {
	public InvalidBookingException(String message) {
		super(message);
	}
}
