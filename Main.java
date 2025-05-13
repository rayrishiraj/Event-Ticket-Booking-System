package Event_Ticket_Booking_System;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EventBookingSystem system = new EventBookingSystem();

		system.loadEventsFromTxt();

		while (true) {
			System.out.println("\n=== Poseidon's Event Booking System ===");
			System.out.println("1. User (Admin)");
			System.out.println("2. Attendee");
			System.out.println("3. Save and Exit");
			System.out.print("Enter your choice: ");
			int choice1 = Integer.parseInt(sc.nextLine());

			switch (choice1) {
			case 1:
				System.out.print("Enter Username: ");
				String username = sc.nextLine();
				System.out.print("Enter Password: ");
				String password = sc.nextLine();

				if (username.equals("Rishi") && password.equals("123456")) {
					System.out.println("Login successful. Welcome, " + username + "!");
					while (true) {
						System.out.println("\n--- Admin Menu ---");
						System.out.println("1. Add Event");
						System.out.println("2. View All Events and Seats");
						System.out.println("3. Logout");
						System.out.print("Choose an option: ");
						int adminChoice = Integer.parseInt(sc.nextLine());

						switch (adminChoice) {
						case 1:
							System.out.print("Enter Event Title: ");
							String title = sc.nextLine();
							System.out.print("Enter Available Tickets: ");
							int tickets = Integer.parseInt(sc.nextLine());
							system.addEvent(title, tickets);
							break;
						case 2:
							system.showEvents();
							break;
						case 3:
							System.out.println("Logging out from Admin...");
							break;
						default:
							System.out.println("Invalid option. Try again.");
						}
						if (adminChoice == 3)
							break;
					}
				} else {
					System.out.println("Invalid user credentials!");
				}
				break;

			case 2:
				System.out.println("\n--- Attendee Menu ---");
				System.out.println("1. Register Attendee");
				System.out.println("2. Show Events");
				System.out.println("3. Book Ticket");
				System.out.println("4. Back to Main Menu");
				System.out.print("Enter your choice: ");
				int customerChoice = Integer.parseInt(sc.nextLine());

				try {
					switch (customerChoice) {
					case 1:
						System.out.print("Enter Attendee ID: ");
						String id = sc.nextLine();
						System.out.print("Enter Name: ");
						String name = sc.nextLine();
						system.registerUser(id, name);
						break;

					case 2:
						system.showEvents();
						break;

					case 3:
						System.out.print("Enter Attendee ID: ");
						String aId = sc.nextLine();
						System.out.print("Enter Event Title: ");
						String eTitle = sc.nextLine();
						system.bookTicket(aId, eTitle);
						break;

					case 4:
						System.out.println("Returning to main menu...");
						break;

					default:
						System.out.println("Invalid choice. Try again.");
					}
				} catch (InvalidBookingException e) {
					System.out.println("Booking Error: " + e.getMessage());
				} catch (Exception e) {
					System.out.println("Unexpected Error: " + e.getMessage());
				}
				break;

			case 3:
				system.saveEventsToTxt();
				System.out.println("Data saved!");
				return;

			default:
				System.out.println("Invalid choice. Please select again.");
			}
			sc.close();
		}
	}
}
