package Contest1009.T4;

/**
 * @author IronSid
 * @since 2022-10-09 10:28
 */
public class Solution {

    public static final int MOD = (int) (1e9 + 7);

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        long[][][] dp = new long[m + 1][n + 1][k];
        dp[1][1][grid[0][0] % k] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int p = 0; p < k; p++) {
                    int q = ((p - grid[i][j]) % k + k) % k;
                    dp[i + 1][j + 1][p] += (dp[i][j + 1][q] + dp[i + 1][j][q]) % MOD;
                }
            }
        }
        return (int) dp[m][n][0];
    }
}
