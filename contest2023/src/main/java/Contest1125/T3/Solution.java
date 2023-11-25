package Contest1125.T3;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2023-10-28 22:33
 */
public class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        // dp[i] 表示获取前i个商品的最小花费
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int p = prices[i - 1];
            dp[i] = Math.min(dp[i], dp[i - 1] + p);
            for (int j = 1; j <= i; j++) {
                if (i + j > n) break;
                dp[i + j] = Math.min(dp[i + j], dp[i - 1] + p);
            }
        }
        return dp[n];
    }
}