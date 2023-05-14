package Contest0514.T3;

/**
 * @author IronSid
 * @since 2023-05-14 16:46
 */
public class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                for (int d = -1; d <= 1; d++) {
                    if (i + d >= 0 && i + d < m) {
                        if (grid[i + d][j + 1] > grid[i][j]) {
                            dp[i][j] = Math.max(dp[i][j], dp[i + d][j + 1] + 1);
                        }
                    }
                }
                if (j == 0) max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}