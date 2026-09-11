package session_4_arraysconcept.assigment_problems;

import java.util.Scanner;

public class Productexpectself {
    static int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        int product = 1;

        // Left side product
        for (int i = 0; i < nums.length; i++) {
            answer[i] = product;
            product = product * nums[i];
        }

        // Right side product
        product = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * product;
            product = product * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = productExceptSelf(nums);

        System.out.println("Result:");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
