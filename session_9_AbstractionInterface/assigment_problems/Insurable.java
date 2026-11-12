package session_9_AbstractionInterface.assigment_problems;


    import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected String type;
    protected double weight;
    protected double declaredValue;

    public Parcel(String type, double weight, double declaredValue) {
        this.type = type;
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateCharge();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) {
        super("STANDARD", weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 40.0 + (10.0 * weight);
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) {
        super("EXPRESS", weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        return 80.0 + (15.0 * weight);
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) {
        super("FRAGILE", weight, declaredValue);
    }

    @Override
    public double calculateCharge() {
        // Standard charge plus a handling fee of 50
        double standardCharge = 40.0 + (10.0 * weight);
        return standardCharge + 50.0;
    }

    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();

            switch (type) {
                case "STANDARD":
                    parcels.add(new StandardParcel(weight, declaredValue));
                    break;
                case "EXPRESS":
                    parcels.add(new ExpressParcel(weight, declaredValue));
                    break;
                case "FRAGILE":
                    parcels.add(new FragileParcel(weight, declaredValue));
                    break;
            }
        }

        double grandTotal = 0.0;
        for (Parcel parcel : parcels) {
            double charge = parcel.calculateCharge();
            double insurance = 0.0;

            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).calculateInsurance();
            }

            double total = charge + insurance;
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.getType(), charge, insurance, total);
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        scanner.close();
    }
}
}
