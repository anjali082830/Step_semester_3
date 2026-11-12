package session_11_SortingAlgorithm.Assigment_problems;


    import java.util.Arrays;

public class HeightLineUp3 {

    public static void lineUp(int[] heights) {
        int pass = 1;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < heights.length - 1; i++) {
                if (heights[i] > heights[i + 1]) {
                    int temp = heights[i];
                    heights[i] = heights[i + 1];
                    heights[i + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            pass++;
        } while (swapped);
    }

    public static void main(String[] args) {
        int[] heights1 = {4, 2, 5, 1};
        System.out.println("Sample 1:");
        lineUp(heights1);

        int[] heights2 = {1, 3, 2, 4};
        System.out.println("\nSample 2:");
        lineUp(heights2);
    }
}

