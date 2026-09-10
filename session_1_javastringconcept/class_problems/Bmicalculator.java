package session_1_javastringconcept.class_problems;

import java.util.Scanner;

public class Bmicalculator {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] height = new double[5];
        double[] weight = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter height: ");
            height[i] = sc.nextDouble();

            System.out.print("Enter weight: ");
            weight[i] = sc.nextDouble();
        }

        for (int i = 0; i < 5; i++) {
            double bmi = weight[i] / (height[i] * height[i]);

            System.out.println("BMI = " + bmi);

            if (bmi < 18.5)
                System.out.println("Underweight");
            else if (bmi < 25)
                System.out.println("Normal");
            else if (bmi < 30)
                System.out.println("Overweight");
            else
                System.out.println("Obese");
        }
    }
}

