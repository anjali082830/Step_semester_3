package session_10_DSALineardatastructure.Assigment1_problems;

public class AttendanceTracker {
   

    /**
     * Calculates total present days and the longest unbroken run of present days.
     * 
     * @param days array of 1s (present) and 0s (absent)
     * @return an array where index 0 is total present days and index 1 is the longest streak
     */
    public static int[] attendanceSummary(int[] days) {
        int totalPresent = 0;
        int maxStreak = 0;
        int currentStreak = 0;

        for (int day : days) {
            if (day == 1) {
                totalPresent++;
                currentStreak++;
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            } else {
                currentStreak = 0; // Reset streak on absence
            }
        }

        return new int[]{totalPresent, maxStreak};
    }

    public static void main(String[] args) {
        // Sample 1
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        int[] result1 = attendanceSummary(days1);
        System.out.println("Present: " + result1[0] + ", Longest streak: " + result1[1]);

        // Sample 2
        int[] days2 = {0, 0, 0};
        int[] result2 = attendanceSummary(days2);
        System.out.println("Present: " + result2[0] + ", Longest streak: " + result2[1]);
    }
}

