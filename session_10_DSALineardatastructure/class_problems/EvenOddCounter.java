package session_10_DSALineardatastructure.class_problems;


    
import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;
        
        String line = scanner.nextLine().trim();
        // Remove brackets if present
        line = line.replace("[", "").replace("]", "").trim();
        
        if (line.isEmpty()) return;
        
        String[] parts = line.split(",\\s*|\\s+");
        int evenCount = 0;
        int oddCount = 0;

        for (String part : parts) {
            if (!part.isEmpty()) {
                int num = Integer.parseInt(part);
                if (num % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
        }

        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
        scanner.close();
    }
}
