package session_2_stringoperationsconcept.class_problems;

import java.util.Scanner;
public class Studentrecordparser {
      static void parsestudentrecord(String csvline){
       String[] fields =csvline.split(",");
       if(fields.length != 3){
        System.out.println("invalid reocrd");
       }
       else{
        System.out.println("Name: "+fields[0]);
        System.out.println("roll no.: "+fields[1]);
        System.out.println("department: "+fields[2]);
       }
      }
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student record in csv format: ");
        String csvline = sc.nextLine();
        parsestudentrecord(csvline);
      }
    
}
