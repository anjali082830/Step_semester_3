package session_5_oopsconcept.Assigment_problems;

    import java.util.Arrays;
import java.util.Scanner;

public class FantasyLeagueRanking {

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        // Constructor
        public Player(String name, int matchesPlayed,
                      double battingAverage, boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Getters
        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        public boolean isInjured() {
            return injured;
        }

        // First overloaded method
        static boolean isDraftable(int matchesPlayed) {

            return matchesPlayed >= 10;
        }

        // Second overloaded method
        static boolean isDraftable(int matchesPlayed,
                                   boolean injured) {

            return matchesPlayed >= 5 && !injured;
        }

        // Fantasy points
        double getFantasyPoints() {

            return battingAverage * 2;
        }

        // Ranking
        @Override
        public int compareTo(Player other) {

            return Double.compare(
                other.getFantasyPoints(),
                this.getFantasyPoints()
            );
        }
    }

    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];

        int count = 0;

        for (int i = 0; i < players.length; i++) {

            if (Player.isDraftable(players[i].getMatchesPlayed())
                ||
                Player.isDraftable(
                    players[i].getMatchesPlayed(),
                    players[i].isInjured())) {

                draftable[count] = players[i];
                count++;
            }
        }

        Player[] finalList = Arrays.copyOf(draftable, count);

        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            result = result + (i + 1) + ". "
                    + finalList[i].getName();

            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {

            sc.nextLine();

            System.out.print("Enter player name: ");
            String name = sc.nextLine();

            System.out.print("Enter matches played: ");
            int matchesPlayed = sc.nextInt();

            System.out.print("Enter batting average: ");
            double battingAverage = sc.nextDouble();

            System.out.print("Is player injured? (true/false): ");
            boolean injured = sc.nextBoolean();

            players[i] = new Player(
                name,
                matchesPlayed,
                battingAverage,
                injured
            );
        }

        System.out.println("\nDraft and Ranking:");

        System.out.println(draftAndRank(players));

        sc.close();
    }
}

