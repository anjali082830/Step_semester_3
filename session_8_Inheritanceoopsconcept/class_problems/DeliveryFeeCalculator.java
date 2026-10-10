package session_8_Inheritanceoopsconcept.class_problems;

    import java.util.Scanner;

abstract class Delivery {
    double weight;
    double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class Standard extends Delivery {
    Standard(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 5 + (weight * 0.50) + (distance * 0.10);
    }
}

class Express extends Delivery {
    Express(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    double calculateFee() {
        return 15 + (weight * 1.00) + (distance * 0.20);
    }
}

class International extends Delivery {
    double customsFee;

    International(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    double calculateFee() {
        return 25 + (weight * 2.00)
                 + (distance * 0.50) + customsFee;
    }


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 1; i <= n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            Delivery d;

            if (type.equals("STANDARD")) {
                d = new Standard(weight, distance);
            } else if (type.equals("EXPRESS")) {
                d = new Express(weight, distance);
            } else {
                double customsFee = sc.nextDouble();
                d = new International(weight, distance, customsFee);
            }

            double fee = d.calculateFee();

            System.out.printf("%s: %.2f%n", type, fee);

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
}
