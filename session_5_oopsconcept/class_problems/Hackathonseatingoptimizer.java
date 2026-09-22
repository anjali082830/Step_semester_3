package session_5_oopsconcept.class_problems;

import java.util.Scanner;

public class Hackathonseatingoptimizer {
     static double rowAverage(int[] row) {

        int sum = 0;

        for (int i = 0; i < row.length; i++) {
            sum = sum + row[i];
        }

        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {

        String result = "";

        for (int i = 0; i < seatingScores.length; i++) {

            double average = rowAverage(seatingScores[i]);

            if (average < threshold) {
                result = result + "Row " + (i + 1) + ": Quiet Zone\n";
            }
            else {
                result = result + "Row " + (i + 1) + ": Buzzing Zone\n";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of scores in each row: ");
        int columns = sc.nextInt();

        int[][] seatingScores = new int[rows][columns];

        for (int i = 0; i < rows; i++) {

            System.out.println("Enter scores for Row " + (i + 1) + ":");

            for (int j = 0; j < columns; j++) {
                seatingScores[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter threshold: ");
        int threshold = sc.nextInt();

        System.out.println("\nResult:");
        System.out.print(classifyRows(seatingScores, threshold));

     sc.close();
    }
}
