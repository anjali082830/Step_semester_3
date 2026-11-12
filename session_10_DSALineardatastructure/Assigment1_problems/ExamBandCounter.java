package session_10_DSALineardatastructure.Assigment1_problems;


    import java.util.Arrays;

public class ExamBandCounter {

    /**
     * Counts the number of scores s such that low <= s <= high in O(log N) time.
     * 
     * @param scores sorted array of student marks
     * @param low minimum mark (inclusive)
     * @param high maximum mark (inclusive)
     * @return number of scores within the band
     */
    public static int countInBand(int[] scores, int low, int high) {
        int startIndex = lowerBound(scores, low);
        int endIndex = upperBound(scores, high);
        return endIndex - startIndex;
    }

    // Helper: Finds the index of the first element >= target
    private static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Helper: Finds the index of the first element > target
    private static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        int low = 42;
        int high = 58;

        int count = countInBand(scores, low, high);
        System.out.println("Expected Output: " + count); // Output: 6
    }
}

