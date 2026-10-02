package session_6_classesandobjects.class_problems;

public class IdCard {
    String name;
    int booksIssued;

    // Constructor
    IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }


    public static void main(String[] args) {

        // Create one object
        IdCard first = new IdCard("Ravi", 2);

        // Second variable points to the SAME object
        IdCard second = first;

        // Change through second variable
        second.booksIssued = 5;

        // Value seen through first variable
        System.out.println("Books issued: " + first.booksIssued);

        // Check whether both variables refer to the same object
        System.out.println("first == second: " + (first == second));

        // Create a separate object with same values
        IdCard third = new IdCard("Ravi", 5);

        // Check whether third and first are the same object
        System.out.println("first == third: " + (first == third));
    }
    
}
