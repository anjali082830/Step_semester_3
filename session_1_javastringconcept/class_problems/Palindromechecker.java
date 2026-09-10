package session_1_javastringconcept.class_problems;

import java.util.*;

class Palindrome {
    
    static boolean iterative(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }

    static boolean recursive(String s) {
        if (s.length() <= 1)
            return true;

        if (s.charAt(0) != s.charAt(s.length() - 1))
            return false;

        return recursive(s.substring(1, s.length() - 1));
    }

    static boolean reversal(String s) {
        String rev = "";

        for (int i = s.length() - 1; i >= 0; i--)
            rev = rev + s.charAt(i);

        return s.equals(rev);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter word: ");
        String s = sc.next();

        System.out.println("Iterative: " + iterative(s));
        System.out.println("Recursive: " + recursive(s));
        System.out.println("Array Reversal: " + reversal(s));
    }
}