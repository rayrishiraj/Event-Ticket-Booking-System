package Event_Ticket_Booking_System;

public class Attendee extends User {

    public Attendee(String id, String name) {
        super(id, name);
    }

    @Override
    public void showProfile() {
        System.out.println("Attendee ID: " + id);
        System.out.println("Name: " + name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
