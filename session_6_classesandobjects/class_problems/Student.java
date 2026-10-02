package session_6_classesandobjects.class_problems;

public class Student {
     String name;
    int attendance;

    // Static fields - shared by all students
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor
    Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;

        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {
        System.out.println("College: " + collegeName);
        System.out.println("Student Count: " + studentCount);
    }


    public static void main(String[] args) {

        // Create two Student objects
        Student s1 = new Student("Anjali", 90);
        Student s2 = new Student("Rahul", 85);

        // Call static method using class name
        Student.printCollegeInfo();
    }
}
    

