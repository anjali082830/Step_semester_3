package session_9_AbstractionInterface.assigment_problems;


    import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface NightServiceable {
    double applyNightSurcharge(double fare);
}

abstract class Cab {
    protected String type;
    protected double km;
    protected String time;

    public Cab(String type, double km, String time) {
        this.type = type;
        this.km = km;
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public String getTime() {
        return time;
    }

    public abstract double getRatePerKm();

    public double calculateFare() throws Exception {
        if (time.equals("NIGHT") && !(this instanceof NightServiceable)) {
            throw new Exception("night service not available");
        }

        double baseFare = km * getRatePerKm();
        double fare = Math.max(100.0, baseFare); // Minimum fare rule

        if (time.equals("NIGHT") && this instanceof NightServiceable) {
            fare = ((NightServiceable) this).applyNightSurcharge(fare);
        }

        return fare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double km, String time) {
        super("MINI", km, time);
    }

    @Override
    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double km, String time) {
        super("SEDAN", km, time);
    }

    @Override
    public double getRatePerKm() {
        return 14.0;
    }

    @Override
    public double applyNightSurcharge(double fare) {
        return fare * 1.20; // Adds 20%
    }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab(double km, String time) {
        super("SUV", km, time);
    }

    @Override
    public double getRatePerKm() {
        return 18.0;
    }

    @Override
    public double applyNightSurcharge(double fare) {
        return fare * 1.20; // Adds 20%
    }


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Cab> trips = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();

            switch (type) {
                case "MINI":
                    trips.add(new MiniCab(km, time));
                    break;
                case "SEDAN":
                    trips.add(new SedanCab(km, time));
                    break;
                case "SUV":
                    trips.add(new SUVCab(km, time));
                    break;
            }
        }

        double total = 0.0;
        for (Cab cab : trips) {
            try {
                double fare = cab.calculateFare();
                total += fare;
                System.out.printf("%s: %.2f%n", cab.getType(), fare);
            } catch (Exception e) {
                System.out.printf("%s: %s%n", cab.getType(), e.getMessage());
            }
        }

        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
}
