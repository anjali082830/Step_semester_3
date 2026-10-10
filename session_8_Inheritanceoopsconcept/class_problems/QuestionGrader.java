package session_8_Inheritanceoopsconcept.class_problems;

    import java.util.Scanner;

abstract class Question {
    String questionText;
    String correctAnswer;
    String studentAnswer;
    double points;

    Question(String questionText, String correctAnswer,
             String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class MCQ extends Question {
    MCQ(String q, String c, String s, double p) {
        super(q, c, s, p);
    }

    @Override
    double calculateScore() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class TF extends Question {
    TF(String q, String c, String s, double p) {
        super(q, c, s, p);
    }

    @Override
    double calculateScore() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0;
    }
}

class Essay extends Question {
    Essay(String q, String c, String s, double p) {
        super(q, c, s, p);
    }

    @Override
    double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int count = 0;

        for (int i = 0; i < keywords.length; i++) {
            if (studentAnswer.toLowerCase().contains(
                    keywords[i].trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double totalScore = 0;

        for (int i = 1; i <= n; i++) {
            String type = sc.next();

            String questionText = sc.findInLine("\"[^\"]*\"");
            questionText = questionText.substring(1, questionText.length() - 1);

            String correctAnswer = sc.findInLine("\"[^\"]*\"");
            correctAnswer = correctAnswer.substring(1, correctAnswer.length() - 1);

            String studentAnswer = sc.findInLine("\"[^\"]*\"");
            studentAnswer = studentAnswer.substring(1, studentAnswer.length() - 1);

            double points = sc.nextDouble();

            Question q;

            if (type.equals("MCQ")) {
                q = new MCQ(questionText, correctAnswer, studentAnswer, points);
            } else if (type.equals("TF")) {
                q = new TF(questionText, correctAnswer, studentAnswer, points);
            } else {
                q = new Essay(questionText, correctAnswer, studentAnswer, points);
            }

            double score = q.calculateScore();

            System.out.printf("%s: %.2f%n", type, score);

            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}
}
