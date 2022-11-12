package Contest1112.T2;

/**
 * @author IronSid
 * @since 2022-11-12 21:44
 */
public class Solution {

    public static final int MOD = (int) (1e9 + 7);

    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high * 2 + 10];
        dp[0] = 1;
        for (int i = 0; i <= high; i++) {
            dp[i + zero] += dp[i];
            dp[i + zero] %= MOD;
            dp[i + one] += dp[i];
            dp[i + one] %= MOD;
        }
        long res = 0;
        for (int i = low; i <= high; i++) {
            res += dp[i];
        }
        return (int) (res % MOD);
    }
}
