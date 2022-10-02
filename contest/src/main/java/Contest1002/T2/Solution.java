package Contest1002.T2;

/**
 * @author IronSid
 * @since 2022-10-02 10:36
 */
public class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int sum = 0;
                sum += grid[i - 1][j - 1];
                sum += grid[i - 1][j];
                sum += grid[i - 1][j + 1];
                sum += grid[i][j];
                sum += grid[i + 1][j - 1];
                sum += grid[i + 1][j];
                sum += grid[i + 1][j + 1];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
