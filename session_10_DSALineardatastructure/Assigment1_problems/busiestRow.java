package session_10_DSALineardatastructure.Assigment1_problems;

public class busiestRow {
    public class CollegeBusGrid {

    /**
     * Finds the index of the row with the largest total students and that total.
     * If there's a tie, returns the row with the smaller index.
     * 
     * @param grid 2D array representing the bus seats
     * @return an array where index 0 is the row index and index 1 is the total
     */
    public static int[] busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new int[]{-1, 0};
        }

        int maxRowIndex = 0;
        int maxTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int currentRowTotal = 0;
            for (int j = 0; j < grid[i].length; j++) {
                currentRowTotal += grid[i][j];
            }

            // Update if strictly greater to keep the smaller index in case of ties
            if (currentRowTotal > maxTotal) {
                maxTotal = currentRowTotal;
                maxRowIndex = i;
            }
        }

        return new int[]{maxRowIndex, maxTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        int[] result = busiestRow(grid);
        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}
}
