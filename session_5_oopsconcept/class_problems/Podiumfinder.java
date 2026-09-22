package session_5_oopsconcept.class_problems;

import java.util.Scanner;

public class Podiumfinder {
     static int[] findTopThreeScores(int[] scores) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i = 0; i < scores.length; i++) {

            if (scores[i] > first) {
                third = second;
                second = first;
                first = scores[i];
            }
            else if (scores[i] > second) {
                third = second;
                second = scores[i];
            }
            else if (scores[i] > third) {
                third = scores[i];
            }
        }

        return new int[] {first, second, third};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of scores: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter score " + (i + 1) + ": ");
            scores[i] = sc.nextInt();
        }

        int[] result = findTopThreeScores(scores);

        System.out.println("Top 3 scores:");
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);

        sc.close();
    }
}
