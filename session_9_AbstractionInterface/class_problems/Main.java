package session_9_AbstractionInterface.class_problems;


    import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Staff {
    private final String name;

    public Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private final double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private final double hours;
    private final double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return (40 * rate) + ((hours - 40) * rate * 1.5);
    }
}

class Intern extends Staff {
    private final double stipend;

    public Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        
        int n = scanner.nextInt();
        List<Staff> staffList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            switch (type) {
                case "FULLTIME":
                    staffList.add(new FullTimeStaff(name, scanner.nextDouble()));
                    break;
                case "HOURLY":
                    staffList.add(new HourlyStaff(name, scanner.nextDouble(), scanner.nextDouble()));
                    break;
                case "INTERN":
                    staffList.add(new Intern(name, scanner.nextDouble()));
                    break;
            }
        }

        double totalPayroll = 0.0;
        for (Staff s : staffList) {
            double pay = s.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f%n", s.getName(), pay);
        }
        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        scanner.close();
    }
}

