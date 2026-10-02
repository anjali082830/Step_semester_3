package session_6_classesandobjects.class_problems;

public class StudentPlacementRecord {
        String studentName;
    String company;
    double packageLpa;

    // Constructor
    StudentPlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    // Instance method
    void printRecord() {
        System.out.println(studentName + " | " + company + " | " + packageLpa + " LPA");
    }



    public static void main(String[] args) {

        // Creating objects
        StudentPlacementRecord p1 = new StudentPlacementRecord("Anjali", "TCS", 6.5);
        StudentPlacementRecord p2 = new StudentPlacementRecord("Rohit", "Infosys", 5.0);
        StudentPlacementRecord p3 = new StudentPlacementRecord("Sneha", "Wipro",7.2);

        StudentPlacementRecord[] records = {p1, p2, p3};

        // Printing each record
        for (StudentPlacementRecord record : records) {
            record.printRecord();
        }
    }
}
    

