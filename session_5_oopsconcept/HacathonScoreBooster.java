package session_5_oopsconcept;

import java.util.Scanner;
import java.util.Arrays;
public class HacathonScoreBooster {
    static void curvescores(int[] scores, int bonus) {
        int n;
        for(int i =0;i<=scores.length-1;i++){
            scores[i] =scores[i]+bonus;
        }

    }
    public static void main(String[] args){
        
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        System.out.println("enter the scores:");
        for(int i=0;i<=scores.length-1;i++){
            scores[i]=sc.nextInt();
        }
        System.out.println("enter the bonus: ");
        int bonus = sc.nextInt();
        curvescores(scores,bonus);
        System.out.println("The scores after adding bonus are: ");
        System.out.println(Arrays.toString(scores));
    }
}
