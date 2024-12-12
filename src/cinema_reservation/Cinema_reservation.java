/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema_reservation;
import static com.sun.javafx.application.PlatformImpl.exit;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class Cinema_reservation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a movie
     

          Scanner myObj = new Scanner(System.in); 
          int ch;
          int choice;
        ArrayList<iteam> orders = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>(); 

        Movie movie1 = new Movie(1, "Inception", 2.5f, "Sci-Fi", 1, 70, 24, "Inception", 10.0);

        System.out.println("\nEnter customer name:");
        String namec = myObj.nextLine();
        Customer customer1 = new Customer(namec);
        customers.add(customer1); 

        System.out.println("\nAdd another customer? 1 for yes, 2 for no:");
        do {
            if (myObj.hasNextInt()) { 
                ch = myObj.nextInt();
                myObj.nextLine(); // Consume newline 
                if (ch == 1) {
                    System.out.println("\nEnter customer name:");
                    String namecr = myObj.nextLine();
                    Customer customer = new Customer(namecr); 
                    customers.add(customer); 
                }
            } else {
                System.out.println("Invalid input. Please enter 1 or 2.");
                myObj.nextLine(); // Clear the invalid input
                ch = 0; // Reset ch to ensure the loop continues
            }
        } while (ch != 2);

        for (Customer customer : customers) {
            movie1.addObserver(customer);
        }

        movie1.notifyObservers("movie_added");

        movie1.setPrice(12.5);

        movie1.addShowtime("2:00 PM");
       

        do {
            System.out.println("\nCinema Reservation System");
            System.out.println("1. Create a new order");
            System.out.println("2. Process an order");
            System.out.println("3. Ship an order");
            System.out.println("4. Cancel an order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = myObj.nextInt();
            myObj.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    iteam newOrder = new iteam(orders.size() + 1);
                    orders.add(newOrder);
                    System.out.println("iteam " + newOrder.getOrderId() + " created.");
                    break;

                case 2:
                    System.out.print("Enter order ID to process: ");
                    int processId = myObj.nextInt();
                    processOrder(orders, processId);
                    break;

                case 3:
                    System.out.print("Enter order ID to ship: ");
                    int shipId = myObj.nextInt();
                    shipOrder(orders, shipId);
                    break;

                case 4:
                    System.out.print("Enter order ID to cancel: ");
                    int cancelId = myObj.nextInt();
                    cancelOrder(orders, cancelId);
                    break;

                case 5:
                    exit();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

    }

    private static void processOrder(ArrayList<iteam> orders, int orderId) { 
        for (iteam order : orders) {
            if (order.getOrderId() == orderId) {
                order.processOrder(); 
                return;
            }
        }
        System.out.println("Order with ID " + orderId + " not found.");
    }

    private static void shipOrder(ArrayList<iteam> orders, int orderId) {
        for (iteam order : orders) {
            if (order.getOrderId() == orderId) {
                order.shipOrder(); 
                return;
            }
        }
        System.out.println("Order with ID " + orderId + " not found.");
    }

    private static void cancelOrder(ArrayList<iteam> orders, int orderId) {
        for (iteam order : orders) {
            if (order.getOrderId() == orderId) {
                order.cancelOrder();
                return;
            }
        }
        System.out.println("Order with ID " + orderId + " not found.");
    }

}
