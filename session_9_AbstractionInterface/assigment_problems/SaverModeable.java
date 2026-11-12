package session_9_AbstractionInterface.assigment_problems;


    import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface SaverModeable {
    // Marker interface for appliances that support saver mode
}

abstract class Appliance {
    protected String typeName;
    protected double hours;
    protected boolean saverRequested;

    public Appliance(String typeName, double hours, boolean saverRequested) {
        this.typeName = typeName;
        this.hours = hours;
        this.saverRequested = saverRequested;
    }

    public String getTypeName() {
        return typeName;
    }

    public boolean isSaverRequested() {
        return saverRequested;
    }

    public abstract double getPower(); // Returns power rating in Watts
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean saverRequested) {
        super("FRIDGE", hours, saverRequested);
    }

    @Override
    public double getPower() {
        return 150.0;
    }
}

class AC extends Appliance implements SaverModeable {
    public AC(double hours, boolean saverRequested) {
        super("AC", hours, saverRequested);
    }

    @Override
    public double getPower() {
        return 1500.0;
    }
}

class TV extends Appliance {
    public TV(double hours, boolean saverRequested) {
        super("TV", hours, saverRequested);
    }

    @Override
    public double getPower() {
        return 100.0;
    }
}

class Washer extends Appliance implements SaverModeable {
    public Washer(double hours, boolean saverRequested) {
        super("WASHER", hours, saverRequested);
    }

    @Override
    public double getPower() {
        return 500.0;
    }


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Appliance> appliances = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }

            String[] parts = line.split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");

            switch (type) {
                case "FRIDGE":
                    appliances.add(new Fridge(hours, saver));
                    break;
                case "AC":
                    appliances.add(new AC(hours, saver));
                    break;
                case "TV":
                    appliances.add(new TV(hours, saver));
                    break;
                case "WASHER":
                    appliances.add(new Washer(hours, saver));
                    break;
            }
        }

        double totalCost = 0.0;
        for (Appliance app : appliances) {
            // Check if saver mode is requested for an unsupported appliance
            if (app.isSaverRequested() && !(app instanceof SaverModeable)) {
                System.out.println(app.getTypeName() + ": saver mode not supported");
            } else {
                double units = (app.getPower() * app.hours) / 1000.0;
                
                // Apply 25% reduction if saver mode is requested and supported
                if (app.isSaverRequested() && (app instanceof SaverModeable)) {
                    units *= 0.75;
                }

                double cost = units * 8.0;
                totalCost += cost;

                System.out.printf("%s: Units=%.2f Cost=%.2f%n", app.getTypeName(), units, cost);
            }
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        scanner.close();
    }
}
}
