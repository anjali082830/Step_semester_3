package session_5_oopsconcept.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class Placementranking {
     static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;

        // Constructor
        Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        // Getter methods
        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        // CGPA-only eligibility
        static boolean isEligible(double cgpa) {
            return cgpa >= 8.0;
        }

        // CGPA + coding score eligibility
        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 7.0 && codingScore >= 70;
        }

        // Composite score
        double getCompositeScore() {
            return (cgpa * 10) + codingScore;
        }

        // Ranking logic
        @Override
        public int compareTo(Candidate other) {
            return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            sc.nextLine();

            System.out.print("Enter candidate name: ");
            String name = sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = sc.nextInt();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        Candidate[] shortlisted = new Candidate[n];
        int count = 0;

        for (int i = 0; i < n; i++) {

            if (Candidate.isEligible(candidates[i].getCgpa()) ||
                Candidate.isEligible(
                    candidates[i].getCgpa(),
                    candidates[i].getCodingScore())) {

                shortlisted[count] = candidates[i];
                count++;
            }
        }

        // Create array containing only shortlisted candidates
        Candidate[] finalList = Arrays.copyOf(shortlisted, count);

        // Sort using Comparable
        Arrays.sort(finalList);

        System.out.println("\nShortlisted Candidates - Ranked:");

        for (int i = 0; i < finalList.length; i++) {

            System.out.println(
                (i + 1) + ". " +
                finalList[i].getName() +
                " | CGPA: " + finalList[i].getCgpa() +
                " | Coding Score: " + finalList[i].getCodingScore() +
                " | Composite Score: " +
                finalList[i].getCompositeScore()
            );
        }

        sc.close();
    }
}
