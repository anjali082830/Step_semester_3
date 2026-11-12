package session_9_AbstractionInterface.assigment_problems;


    import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class TicketBooking {
    protected static final double CONVENIENCE_FEE = 20.0;
    protected final String seatType;
    protected final int count;

    public TicketBooking(String seatType, int count) {
        this.seatType = seatType;
        this.count = count;
    }

    public String getSeatType() {
        return seatType;
    }

    // Subclasses only need to provide their base price per ticket
    protected abstract double getPricePerTicket();

    // Convenience fee logic is written here in ONE place
    public double calculateTotal() {
        return (getPricePerTicket() + CONVENIENCE_FEE) * count;
    }
}

class RegularBooking extends TicketBooking {
    public RegularBooking(int count) {
        super("REGULAR", count);
    }

    @Override
    protected double getPricePerTicket() {
        return 150.0;
    }
}

class PremiumBooking extends TicketBooking {
    public PremiumBooking(int count) {
        super("PREMIUM", count);
    }

    @Override
    protected double getPricePerTicket() {
        return 250.0;
    }
}

class ReclinerBooking extends TicketBooking {
    public ReclinerBooking(int count) {
        super("RECLINER", count);
    }

    @Override
    protected double getPricePerTicket() {
        return 400.0;
    }


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<TicketBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int count = scanner.nextInt();

            switch (type) {
                case "REGULAR":
                    bookings.add(new RegularBooking(count));
                    break;
                case "PREMIUM":
                    bookings.add(new PremiumBooking(count));
                    break;
                case "RECLINER":
                    bookings.add(new ReclinerBooking(count));
                    break;
            }
        }

        double total = 0.0;
        for (TicketBooking booking : bookings) {
            double amount = booking.calculateTotal();
            total += amount;
            System.out.printf("%s: %.2f%n", booking.getSeatType(), amount);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
}
