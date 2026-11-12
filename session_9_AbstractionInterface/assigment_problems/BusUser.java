package session_9_AbstractionInterface.assigment_problems;


    import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class Student {
    protected final String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateTuition();
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0;
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 40000.0 + 60000.0; // Tuition plus hostel fee
    }
}

class Scholar extends Student implements BusUser {
    public Scholar(String name) {
        super(name);
    }

    @Override
    public double calculateTuition() {
        return 20000.0; // Half of normal tuition (40000)
    }

    @Override
    public double getTransportFee() {
        return 12000.0;
    }


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholar(name));
                    break;
                case "HOSTELLER":
                    students.add(new Hosteller(name));
                    break;
                case "SCHOLAR":
                    students.add(new Scholar(name));
                    break;
            }
        }

        double totalCollected = 0.0;
        for (Student student : students) {
            double fee = student.calculateTuition();
            if (student instanceof BusUser) {
                fee += ((BusUser) student).getTransportFee();
            }
            totalCollected += fee;
            System.out.printf("%s: %.2f%n", student.getName(), fee);
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        scanner.close();
    }
}
}
