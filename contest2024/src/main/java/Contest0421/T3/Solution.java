package Contest0421.T3;

/**
 * @author IronSid
 * @since 2024-04-21 9:39
 */
public class Solution {
    public int minimumOperations(int[][] grid) {
        int M = 10;
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[n][M];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[j][grid[i][j]]++;
            }
        }
        // dp(i,j)表示前i列转化，且第i列转化为j的最小操作数
        int[][] dp = new int[n + 1][M];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < M; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < M; k++) {
                    if (j == k) continue;
                    min = Math.min(min, dp[i][k]);
                }
                dp[i+1][j] = min + m - f[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            res = Math.min(res, dp[n][j]);
        }
        return res;
    }
}
