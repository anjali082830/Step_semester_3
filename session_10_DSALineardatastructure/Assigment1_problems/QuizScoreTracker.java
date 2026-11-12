package session_10_DSALineardatastructure.Assigment1_problems;


    public class QuizScoreTracker {

    /**
     * Finds the second-highest distinct score in an array without sorting.
     * 
     * @param scores array of player scores
     * @return the second-highest distinct score, or -1 if it doesn't exist
     */
    public static int secondHighest(int[] scores) {
        if (scores == null || scores.length < 2) {
            return -1;
        }

        int first = -1;
        int second = -1;

        for (int score : scores) {
            if (score > first) {
                second = first;
                first = score;
            } else if (score < first && score > second) {
                second = score;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] scores = {45, 78, 92, 78, 60};
        int result = secondHighest(scores);
        System.out.println("Expected Output: " + result); // Output: 78
    }
}

