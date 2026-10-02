package session_6_classesandobjects.assigment_problems;

public class Employee2 {
  

    // Instance fields
    String empName;
    double salary;

    // Static fields
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor
    Employee2(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    // Static method
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }


public class Main {
    public static void main(String[] args) {

        Employee2 e1 = new Employee2("Divya", 65000);
        Employee2 e2 = new Employee2("Arjun", 55000);
        Employee2 e3 = new Employee2("Ravi", 60000);

        Employee2.printCompanyInfo();
    }
}
}
