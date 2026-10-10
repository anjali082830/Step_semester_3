package session_8_Inheritanceoopsconcept.class_problems;

    import java.util.Scanner;

abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        double fare = 2 + (distance * 0.10);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    @Override
    double calculateFare() {
        return 3 + (distance * 0.15);
    }
}

class Metro extends Transport {
    double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    double calculateFare() {
        return (1.50 + (distance * 0.20)) * peakHourFactor;
    }


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 1; i <= n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Transport t;

            if (type.equals("BUS")) {
                t = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                t = new Train(distance);
            } else {
                double factor = sc.nextDouble();
                t = new Metro(distance, factor);
            }

            double fare = t.calculateFare();

            System.out.printf("%s: %.2f%n", type, fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
}
