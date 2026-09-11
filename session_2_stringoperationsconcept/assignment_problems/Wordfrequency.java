package session_2_stringoperationsconcept.assignment_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Wordfrequency {
    static void printFilteredWordFrequency(String feedback) {

        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.split("\\s+");

        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {

            boolean stop = false;

            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    stop = true;
                    break;
                }
            }

            if (!stop) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        for (String word : list) {
            System.out.println(word + ": " + map.get(word));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);
    }
}
