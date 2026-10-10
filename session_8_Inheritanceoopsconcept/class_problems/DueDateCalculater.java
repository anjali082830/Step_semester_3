package session_8_Inheritanceoopsconcept.class_problems;

    import java.util.Scanner;
import java.time.LocalDate;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getBorrowingDays();

    LocalDate calculateDueDate() {
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        return currentDate.plusDays(getBorrowingDays());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    @Override
    int getBorrowingDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    @Override
    int getBorrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    @Override
    int getBorrowingDays() {
        return 3;
    }


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            String type = sc.next();
            String title = sc.nextLine().trim();

            // Remove the double quotes from the title
            title = title.replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            System.out.println(title + ": " + item.calculateDueDate());
        }

        sc.close();
    }
}
}
