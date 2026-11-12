package session_11_SortingAlgorithm.class_problems;


    import java.util.HashMap;
import java.util.Map;

public class EmployeeDirectoryLookup {

    /**
     * Builds a HashMap lookup from an unsorted list of records.
     * 
     * Justification: Since queries happen dozens of times per day and updates are rare (few times per month),
     * paying an upfront O(N) cost to build a hash map is highly efficient because subsequent 
     * individual queries execute in O(1) average time.
     * 
     * Complexity Analysis:
     * - buildLookup Time Complexity: O(N)
     * - getDepartment Time Complexity: O(1) average
     * - Space Complexity: O(N) to store the key-value pairs in the lookup map.
     */
    public static Map<String, String> buildLookup(String[][] records) {
        Map<String, String> lookup = new HashMap<>();
        for (String[] record : records) {
            lookup.put(record[0], record[1]);
        }
        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        String[][] records = {
            {"E245", "Finance"},
            {"E110", "Engineering"},
            {"E390", "Marketing"},
            {"E101", "Engineering"}
        };

        Map<String, String> lookup = buildLookup(records);

        System.out.println(getDepartment(lookup, "E390")); // Marketing
        System.out.println(getDepartment(lookup, "E999")); // Unknown
    }
}

