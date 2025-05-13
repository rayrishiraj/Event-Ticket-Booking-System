package Event_Ticket_Booking_System;

public class Ticket {
	private Attendee attendee;
	private Event event;
	private String status;

	public Ticket(Attendee attendee, Event event) {
		this.attendee = attendee;
		this.event = event;
		this.status = "Booked";
	}


	public String ticketDetails() {
		return "Ticket for: " + event.getTitle() + " | Attendee: " + attendee.name + " | Status: " + status;
	}

	public Attendee getAttendee() {
		return attendee;
	}

	public Event getEvent() {
		return event;
	}
}
