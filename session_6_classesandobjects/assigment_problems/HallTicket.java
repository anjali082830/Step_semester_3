package session_6_classesandobjects.assigment_problems;

public class HallTicket {
   

    String studentName;
    int seatNumber;

    // Constructor
    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }


public class Main {
    public static void main(String[] args) {

        // First object
        HallTicket priya = new HallTicket("Priya", 0);

        // Second variable points to the same object
        HallTicket copy = priya;

        // Change using second variable
        copy.seatNumber = 45;

        // Print value using first variable
        System.out.println(
                "Priya's seatNumber (via first variable): "
                + priya.seatNumber);

        // Check same object
        System.out.println("copy == priya: " + (copy == priya));

        // Create separate object
        HallTicket separate = new HallTicket("Priya", 45);

        // Check separate object
        System.out.println(
                "separate == priya: " + (separate == priya));
    }
}

}
