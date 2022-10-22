package Contest1022.T4;

/**
 * @author IronSid
 * @since 2022-10-22 15:03
 */
public class Solution {
    public int brilliantSurprise(int[][] present, int limit) {
        int m = present.length;
        int[][] dp = new int[m + 1][limit + 1];
        int sumN = 0;
        for (int i = 1; i <= m; i++) {
            int[] pre = present[i - 1];
            int n = pre.length;
            int[] v = new int[n + 1];
            for (int i1 = 0, t = 0; i1 < n; i1++) {
                t += pre[i1];
                v[i1 + 1] = t;
            }
            sumN += n;
            for (int j = 1; j <= Math.min(limit, sumN); j++) {
                int max = 0;
                for (int p = 0; p <= n && p <= j; p++) {
                    max = Math.max(max, dp[i - 1][j - p] + v[p]);
                }
                dp[i][j] = max;
            }
        }
        return dp[m][limit];
    }
}
