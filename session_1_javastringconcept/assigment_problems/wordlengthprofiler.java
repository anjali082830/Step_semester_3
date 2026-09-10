package session_1_javastringconcept.assigment_problems;

public class wordlengthprofiler {
    public class Main {
    static void classifyWordLengths(String review) {

        String[] words = review.split(" ");

        int shortWord = 0;
        int mediumWord = 0;
        int longWord = 0;

        for (int i = 0; i < words.length; i++) {

            int length = words[i].length();

            if (length <= 4) {
                shortWord++;
            } 
            else if (length <= 8) {
                mediumWord++;
            } 
            else {
                longWord++;
            }
        }

        System.out.println("Short: " + shortWord);
        System.out.println("Medium: " + mediumWord);
        System.out.println("Long: " + longWord);
    }

    public static void main(String[] args) {

        classifyWordLengths(
            "This movie was absolutely fantastic and thrilling"
        );
    }
}
}
