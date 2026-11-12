package session_11_SortingAlgorithm.Assigment_problems;


    import java.util.Arrays;

public class HeightLineUp {

    /**
     * Sorts student heights by swapping adjacent elements and prints the line 
     * after each sweep. Stops when a sweep makes no swaps.
     * 
     * @param heights array of student heights
     */
    public static void lineUp(int[] heights) {
        int pass = 1;
        boolean swapped;

        do {
            swapped = false;
            // Sweep from left to right, swapping adjacent elements if out of order
            for (int i = 0; i < heights.length - 1; i++) {
                if (heights[i] > heights[i + 1]) {
                    int temp = heights[i];
                    heights[i] = heights[i + 1];
                    heights[i + 1] = temp;
                    swapped = true;
                }
            }

            // Print the line after every sweep
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            pass++;

        } while (swapped); // Stop if a sweep makes no swaps at all
    }

    public static void main(String[] args) {
        // Test Sample 1
        System.out.println("Sample 1 Output:");
        int[] heights1 = {4, 2, 5, 1};
        lineUp(heights1);

        System.out.println("\nSample 2 Output:");
        // Test Sample 2
        int[] heights2 = {1, 3, 2, 4};
        lineUp(heights2);

        System.out.println("\nCustom Test Input Output:");
        // Custom Test Input
        int[] customHeights = {5, 1, 4, 2};
        lineUp(customHeights);
    }
}

