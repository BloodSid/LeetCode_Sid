import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 *
 * @author IronSid
 * @create 2021-07-08 21:57
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int j = 0;
            for (; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1)
                    break;
            }
            //所有的dp[i-coins[j]]都是-1
            //则j=coins.length
            //dp[i] = -1;即不变
            if (j != coins.length) {
                dp[i] = dp[i - coins[j]];
                j++;
                for (; j < coins.length; j++) {
                    if (i - coins[j] >= 0 && dp[i - coins[j]] != -1)
                        dp[i] = Math.min(dp[i], dp[i - coins[j]]);
                }
                dp[i]++;
            }
        }
        return dp[amount];
    }
}
