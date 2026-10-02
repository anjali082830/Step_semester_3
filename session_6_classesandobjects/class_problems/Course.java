package session_6_classesandobjects.class_problems;

public class Course {
     String code;
    String title;
    int credits;
    int labCredits;

    // Four-argument constructor
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Three-argument constructor
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    // Method to calculate total credits
    public int totalCredits() {
        return credits + labCredits;
    }



    public static void main(String[] args) {

        // Course with theory + lab
        Course c1 = new Course("CS101", "Java Programming", 3, 2);

        // Theory-only course
        Course c2 = new Course("MA101", "Mathematics", 4);

        System.out.println("Total credits of Course 1: " + c1.totalCredits());
        System.out.println("Total credits of Course 2: " + c2.totalCredits());
    }
}
