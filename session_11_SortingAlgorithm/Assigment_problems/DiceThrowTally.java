package session_11_SortingAlgorithm.Assigment_problems;


    import java.util.Arrays;

public class DiceThrowTally {

    /**
     * Counts the frequencies of each roll from 1 to 6, prints the counts, 
     * and reconstructs the sorted array in increasing order.
     * 
     * @param rolls array of dice rolls (1 to 6)
     * @return sorted array of rolls
     */
    public static int[] diceSort(int[] rolls) {
        // Frequency array for numbers 1 to 6 (index 0 unused or used for 1-based mapping)
        int[] counts = new int[7];

        // Step 1: Count occurrences of each number
        for (int roll : rolls) {
            if (roll >= 1 && roll <= 6) {
                counts[roll]++;
            }
        }

        // Step 2: Print the counts in the specified format
        System.out.print("Counts: ");
        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + counts[i]);
            if (i < 6) {
                System.out.print(" ");
            }
        }
        System.out.println();

        // Step 3: Rebuild the sorted array using the counts
        int[] sortedRolls = new int[rolls.length];
        int index = 0;
        for (int i = 1; i <= 6; i++) {
            while (counts[i] > 0) {
                sortedRolls[index++] = i;
                counts[i]--;
            }
        }

        return sortedRolls;
    }

    public static void main(String[] args) {
        // Test Sample
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};
        int[] sorted = diceSort(rolls);
        
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}

