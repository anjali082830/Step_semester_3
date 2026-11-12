package session_11_SortingAlgorithm.class_problems;


    public class WarehouseBinScan {

    /**
     * Scans a warehouse grid to compute the total items and find the max bin coordinates.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(m * n) where m is rows and n is columns, as every cell is visited once.
     * - Space Complexity: O(1) additional space beyond the input grid.
     */
    public static String warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return "total = 0, maxCoordinate = (-1, -1)";
        }

        int total = 0;
        int maxVal = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int items = grid[i][j];
                total += items;

                // Strictly greater ensures the first encountered tie is preserved
                if (items > maxVal) {
                    maxVal = items;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        return "total = " + total + ", maxCoordinate = (" + maxRow + ", " + maxCol + ")";
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        System.out.println(warehouseSummary(grid)); 
        // Expected Output: total = 49, maxCoordinate = (2, 1)
    }
}

