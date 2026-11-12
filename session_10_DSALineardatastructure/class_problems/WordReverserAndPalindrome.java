package session_10_DSALineardatastructure.class_problems;


    import java.util.Scanner;

public class WordReverserAndPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()) {
            String word = scanner.next();
            
            // Reverse the word using StringBuilder
            StringBuilder sb = new StringBuilder(word);
            String reversed = sb.reverse().toString();
            
            // Check if original word equals its reverse (case-insensitive if needed, or exact match)
            if (word.equalsIgnoreCase(reversed)) {
                System.out.println(reversed + " - palindrome");
            } else {
                System.out.println(reversed + " - not a palindrome");
            }
        }
        scanner.close();
    }
}

