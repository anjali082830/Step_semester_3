package session_1_javastringconcept.class_problems;

import java.util.Scanner;

public class Reversecustomername {
     static String reverseCustomerName(String name) {
        String reverse = "";

        for (int i = name.length() - 1; i >= 0; i--) {
            reverse = reverse + name.charAt(i);
        }

        return reverse;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        String reverse = reverseCustomerName(name);

        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reverse);
    }
}

