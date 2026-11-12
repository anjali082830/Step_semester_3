package session_11_SortingAlgorithm.class_problems;


    import java.util.HashSet;

public class TransactionDuplicateCheck {

    /**
     * Checks if any transaction ID appears more than once.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(N) where N is the number of transactions.
     * - Space Complexity: O(N) to store unique IDs in the HashSet.
     * 
     * Alternative Approach Trade-Off:
     * An alternative approach is to sort the array and check adjacent elements. 
     * That reduces extra memory to O(1) or O(log N), but increases time complexity 
     * to O(N log N). Given that processing millions of transactions is time-sensitive, 
     * trading memory for O(1) average lookups using a HashSet is the optimal choice.
     */
    public static boolean hasDuplicate(String[] transactionIds) {
        HashSet<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true; // Duplicate found
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] batch1 = {"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"};
        String[] batch2 = {"TXN2001", "TXN2002", "TXN2003"};

        System.out.println(hasDuplicate(batch1)); // true
        System.out.println(hasDuplicate(batch2)); // false
    }
}

