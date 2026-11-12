package session_10_DSALineardatastructure.class_problems;


    import java.util.Scanner;

public class InPlaceArrayReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) return;
        
        String line = scanner.nextLine().trim();
        line = line.replace("[", "").replace("]", "").trim();
        
        if (line.isEmpty()) {
            System.out.println("[]");
            return;
        }
        
        String[] parts = line.split(",\\s*|\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        // In-place reversal using two pointers
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        // Print formatted output matching [44, 33, 22, 11]
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        scanner.close();
    }
}

