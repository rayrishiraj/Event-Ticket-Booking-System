package Event_Ticket_Booking_System;

import java.io.*;
import java.util.*;

public class EventBookingSystem {
	private List<Attendee> attendees = new ArrayList<>();
	// private List<Organizer> organizers = new ArrayList<>();
	private List<Event> events = new ArrayList<>();
	private List<Ticket> tickets = new ArrayList<>();

	public void registerUser(String id, String name) {
		Attendee attendee = new Attendee(id, name);
		attendees.add(attendee);
		System.out.println("Attendee registered successfully.");
	}

	public void addEvent(String title, int availableTickets) {
		events.add(new Event(title, availableTickets));
		System.out.println("Event added successfully.");
	}

	public void bookTicket(String attendeeId, String eventTitle) throws InvalidBookingException {
		Attendee attendee = null;
		for (Attendee a : attendees) {
			if (a.getId().equals(attendeeId)) {
				attendee = a;
				break;
			}
		}

		if (attendee == null) {
			throw new InvalidBookingException("Attendee not found.");
		}

		Event selectedEvent = null;
		for (Event e : events) {
			if (e.getTitle().equalsIgnoreCase(eventTitle) && e.isAvailable()) {
				selectedEvent = e;
				break;
			}
		}

		if (selectedEvent == null) {
			throw new InvalidBookingException("Event not found or no tickets available.");
		}

		selectedEvent.setAvailableTickets(selectedEvent.getAvailableTickets() - 1);
		Ticket ticket = new Ticket(attendee, selectedEvent);
		tickets.add(ticket);
		System.out.println("Ticket booked successfully.");
	}

	public void showEvents() {
		if (events.isEmpty()) {
			System.out.println("No events available.");
		} else {
			for (Event e : events) {
				System.out.println(e);
			}
		}
	}

	public void saveEventsToTxt() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Event_Ticket_Booking_System/events.txt"))) {
			for (Event event : events) {
				writer.write(event.getTitle() + "," + event.getAvailableTickets());
				writer.newLine();
			}
			System.out.println("Events saved to text file.");
		} catch (IOException e) {
			System.out.println("Error saving events: " + e.getMessage());
		}
	}

	public void loadEventsFromTxt() {
		File file = new File("src/Event_Ticket_Booking_System/events.txt");
		if (!file.exists()) {
			System.out.println("No saved events found.");
			return;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			events.clear();
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 2) {
					String title = parts[0];
					int tickets = Integer.parseInt(parts[1]);
					events.add(new Event(title, tickets));
				}
			}
			System.out.println("Events loaded from text file.");
		} catch (IOException e) {
			System.out.println("Error loading events: " + e.getMessage());
		}
	}

	// Getters
	public List<Attendee> getAttendees() {
		return attendees;
	}

//	public List<Organizer> getOrganizers() {
	//	return organizers;
	//}

	public List<Event> getEvents() {
		return events;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}
}
