import java.time.LocalDate;
import java.util.Map;

/**
 * Test program for the Ticket System
 */
public class TestTicketSystem {
    public static void main(String[] args) {
        System.out.println("=== Ticket System Test ===");
        
        // Create a rental system
        RentalSystem system = new RentalSystem();
        
        // Create test data
        Customer customer = new Customer(1, "John Doe", "123-456-7890");
        Vehicle vehicle = new Vehicle(1, "Toyota", "Camry", VehicleStatus.AVAILABLE, 0.1, 50.0, null);
        
        // Create a rental
        Rental rental = new Rental(1, customer, vehicle, LocalDate.now(), LocalDate.now().plusDays(3), 
                                 RentalStatus.PENDING, 150.0, true, "john_doe");
        
        // Test ticket generation
        TicketService ticketService = new TicketService();
        
        System.out.println("1. Generating ticket for rental...");
        Ticket ticket = ticketService.generateTicket(rental);
        
        System.out.println("\n2. Displaying ticket details:");
        ticket.displayTicket();
        
        System.out.println("\n3. Displaying customer tickets:");
        ticketService.displayCustomerTickets("John Doe");
        
        System.out.println("\n4. Testing ticket validation:");
        boolean validation1 = ticketService.validateAndUseTicket(ticket.getTicketId(), "John Doe");
        System.out.println("First validation: " + validation1);
        
        boolean validation2 = ticketService.validateAndUseTicket(ticket.getTicketId(), "John Doe");
        System.out.println("Second validation (should fail): " + validation2);
        
        System.out.println("\n5. Ticket statistics:");
        Map<String, Integer> stats = ticketService.getTicketStats();
        System.out.println("Total tickets: " + stats.get("total"));
        System.out.println("Valid tickets: " + stats.get("valid"));
        System.out.println("Used tickets: " + stats.get("used"));
        
        System.out.println("\n=== Test Complete ===");
    }
} 