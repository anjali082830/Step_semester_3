package session_1_javastringconcept.assigment_problems;

public class Trafficsignalstreak {
    static void findLongestStreak(String signal) {

        int count = 1;
        int max = 1;
        char maxColor = signal.charAt(0);

        for (int i = 1; i < signal.length(); i++) {

            if (signal.charAt(i) == signal.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count > max) {
                max = count;
                maxColor = signal.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + maxColor +
                           "' repeated " + max + " times");
    }

    public static void main(String[] args) {

        findLongestStreak("RRGGGYRR");
    }
}

