package session_5_oopsconcept.class_problems;

import java.util.Scanner;

public class Duplicatenamefinder {
    
    static String findDuplicateTeam(String[] teamNames) {

        for (int i = 0; i < teamNames.length; i++) {

            for (int j = i + 1; j < teamNames.length; j++) {

                if (teamNames[i].equals(teamNames[j])) {
                    return teamNames[i];
                }
            }
        }

        return "No duplicate found";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int n = sc.nextInt();

        sc.nextLine();

        String[] teamNames = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter team name " + (i + 1) + ": ");
            teamNames[i] = sc.nextLine();
        }

        String result = findDuplicateTeam(teamNames);

        System.out.println("Result: " + result);

        sc.close();
    }
}
