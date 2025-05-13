package Event_Ticket_Booking_System;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RoleRequired {
    String role();
}
