package session_10_DSALineardatastructure.Assigment1_problems;


   import java.util.Arrays;

public class RosterRotator {

    /**
     * Rotates the roster array to the right by k places with wrap-around.
     * 
     * @param names array of names
     * @param k number of places to rotate right
     * @return a new rotated array of names
     */
    public static String[] rotateRoster(String[] names, int k) {
        if (names == null || names.length == 0) {
            return names;
        }

        int n = names.length;
        // Handle k larger than the array length
        int effectiveK = k % n;
        if (effectiveK == 0) {
            return names.clone();
        }

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            // Shift each element to its new position with wrap-around
            int newIndex = (i + effectiveK) % n;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        // Sample 1
        String[] names1 = {"A", "B", "C", "D", "E"};
        String[] result1 = rotateRoster(names1, 2);
        System.out.println(Arrays.toString(result1)); // [D, E, A, B, C]

        // Sample 2
        String[] names2 = {"A", "B", "C", "D", "E"};
        String[] result2 = rotateRoster(names2, 7);
        System.out.println(Arrays.toString(result2)); // [D, E, A, B, C]
    }
}

