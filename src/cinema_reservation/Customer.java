package cinema_reservation;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements Observer {
    private String name;
    private ArrayList<Ticket> bookedTickets; 

    public Customer(String name) {
        this.name = name;
        this.bookedTickets = new ArrayList<>();
    }

    public void update(String updateType, Movie movie) {
        if (updateType.equals("movie_added")) {
            System.out.println(name + ": New movie added: " + movie.getTitle() + 
                               " - " + movie.getGenre() + " - $" + movie.getPrice());
            // Ask if the customer wants to see showtimes for the new movie
            Scanner scanner = new Scanner(System.in);
            System.out.print("Would you like to see showtimes for " + movie.getTitle() + "? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                // In a real application, you would fetch and display showtimes here
                System.out.println("Showtimes for " + movie.getTitle() + ":");
                System.out.println(" - 10:00 AM");
                System.out.println(" - 2:00 PM");
                System.out.println(" - 6:00 PM");
                // ... and then potentially allow the customer to book a ticket
            }
        } else if (updateType.equals("price_change")) {
            System.out.println(name + ": Price changed for " + movie.getTitle() + 
                               " to $" + movie.getPrice());
            // You could ask the customer if they want to proceed with their booking 
            // or if they want to cancel it due to the price change
        } else if (updateType.equals("showtime_added")) {
            System.out.println(name + ": New showtime added for " + movie.getTitle() + 
                               "! Check available showtimes.");
            // Similar to the "movie_added" case, you could display the new showtimes
            // and allow the customer to book a ticket
        }
    }

    public void bookTicket(Movie movie, String showtime) {
        // Logic to book a ticket (e.g., create a Ticket object, 
        // add it to bookedTickets, update seat availability)
        Ticket ticket = new Ticket(movie, showtime);
        bookedTickets.add(ticket);
        System.out.println(name + ": Ticket booked for " + movie.getTitle() + 
                           " at " + showtime);
    }

    // ... other methods like view booked tickets, cancel tickets, etc. ...
}

// Ticket.java (You'll need to create this class)
