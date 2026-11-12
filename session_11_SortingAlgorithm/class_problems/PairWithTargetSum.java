package session_11_SortingAlgorithm.class_problems;


    import java.util.HashSet;

public class PairWithTargetSum {

    /**
     * Determines whether any two distinct elements in the list add up to the target.
     * 
     * Approach & Complexity:
     * - Hash Set Approach (Implemented below): Time Complexity O(N), Space Complexity O(N). 
     *   Iterates through the array and checks if (target - num) exists in the set.
     * - Two-Pointer Approach (Alternative): Requires sorting first — Time Complexity O(N log N), 
     *   Space Complexity O(1) (if sorting in-place).
     * - Brute Force (Alternative): Check all pairs — Time Complexity O(N^2), Space Complexity O(1).
     */
    public static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] nums2 = {3, 4, 6};
        int target2 = 20;

        System.out.println(hasPairWithSum(nums1, target1)); // true (2 + 7 = 9)
        System.out.println(hasPairWithSum(nums2, target2)); // false
    }
}

