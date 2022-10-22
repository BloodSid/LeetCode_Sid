package Contest1022.T4;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2022-10-22 15:03
 */
public class Solution {
    public int brilliantSurprise(int[][] present, int limit) {
        int[] dp = new int[limit + 1];
        int[] ndp = new int[limit + 1];
        int bound = 0;
        for (int[] p : present) {
            int n = p.length;
            bound += n;
            Arrays.fill(ndp, 0);
            int l = Math.min(limit, bound);
            for (int i = 0, t = 0; i <= l; i++) {
                ndp[i] = Math.max(dp[i], dp[l - i] + t);
                if (i < n) t += p[i];
            }
            int[] t = dp;
            dp = ndp;
            ndp = t;
        }
        return dp[limit];
    }
}
