import java.util.*;

class Solution{
    public int equalPairs(int[][] grid){
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();
        int count = 0;

        // Step 1: Convert each row to a string and store in rowMap
        for (int[] row : grid){
            String key = Arrays.toString(row);
            rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
        }

        // Step 2: Convert each column to a string and check against rowMap
        for (int j = 0; j < n; j++){
            int[] col = new int[n];
            for (int i = 0; i < n; i++){
                col[i] = grid[i][j];
            }
            String colKey = Arrays.toString(col);
            count += rowMap.getOrDefault(colKey, 0);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid1 = {
                {3, 2, 1},
                {1, 7, 6},
                {2, 7, 7}
        };
        System.out.println("Output: " + sol.equalPairs(grid1)); // Output: 1

        int[][] grid2 = {
                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}
        };
        System.out.println("Output: " + sol.equalPairs(grid2)); // Output: 3
    }
}
