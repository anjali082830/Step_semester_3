package session_7_Encapsulationconcept.class_problems;

    import java.util.Scanner;

class AttendanceSheet {

    private String[] students;
    private int count;

    public AttendanceSheet(int size) {
        students = new String[size];
        count = 0;
    }

    public void markPresent(String name) {

        if (isPresent(name)) {
            return;
        }

        if (count < students.length) {
            students[count] = name;
            count++;
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {

        for (int i = 0; i < count; i++) {

            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum class size: ");
        int size = sc.nextInt();

        sc.nextLine();

        AttendanceSheet sheet = new AttendanceSheet(size);

        System.out.print("Enter number of students to mark present: ");
        int n = sc.nextInt();

        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.print("Enter student " + i + " name: ");
            String name = sc.nextLine();

            sheet.markPresent(name);
        }

        System.out.println("Present Count: " + sheet.getPresentCount());

        System.out.print("Enter name to check: ");
        String searchName = sc.nextLine();

        if (sheet.isPresent(searchName)) {
            System.out.println(searchName + " is present.");
        } else {
            System.out.println(searchName + " is absent.");
        }

        sc.close();
    }
}
}
