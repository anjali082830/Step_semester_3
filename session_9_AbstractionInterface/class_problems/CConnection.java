package session_9_AbstractionInterface.class_problems;


    import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Connection {
    protected final String type;
    protected final double units;

    public Connection(String type, double units) {
        this.type = type;
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateBill();
}

class HomeConnection extends Connection {
    public HomeConnection(double units) {
        super("HOME", units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100.0) {
            return units * 5.0;
        }
        return (100.0 * 5.0) + ((units - 100.0) * 7.0);
    }
}

class ShopConnection extends Connection {
    public ShopConnection(double units) {
        super("SHOP", units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(double units) {
        super("FACTORY", units);
    }

    @Override
    public double calculateBill() {
        return Math.max(1000.0, units * 6.0);
    }
}

public class CConnection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Connection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();

            switch (type) {
                case "HOME":
                    connections.add(new HomeConnection(units));
                    break;
                case "SHOP":
                    connections.add(new ShopConnection(units));
                    break;
                case "FACTORY":
                    connections.add(new FactoryConnection(units));
                    break;
            }
        }

        double total = 0.0;
        for (Connection c : connections) {
            double bill = c.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", c.getType(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}

