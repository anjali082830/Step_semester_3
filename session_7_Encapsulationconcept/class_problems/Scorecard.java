package session_7_Encapsulationconcept.class_problems;


    import java.util.Scanner;

class Scorecard {

    private boolean[] results;
    private int count;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        count = 0;
    }

    public void recordAnswer(boolean correct) {

        if (count < results.length) {
            results[count] = correct;
            count++;
        } else {
            System.out.println("No more answers can be recorded.");
        }
    }

    public int getScore() {

        int score = 0;

        for (int i = 0; i < results.length; i++) {
            if (results[i] == true) {
                score++;
            }
        }

        return score;
    }


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of questions: ");
        int n = sc.nextInt();

        Scorecard scard = new Scorecard(n);

        for (int i = 1; i <= n; i++) {

            System.out.print("Was question " + i + " correct? (true/false): ");
            boolean answer = sc.nextBoolean();

            scard.recordAnswer(answer);
        }

        System.out.println("Final Score: " + scard.getScore());

        sc.close();
    }
}
}
