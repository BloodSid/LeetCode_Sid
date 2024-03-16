package Contest0316.T4;

/**
 * @author IronSid
 * @since 2024-03-16 22:26
 */
public class Solution {

    public static final int M = (int) (1e9+7);

    public int sumOfPower(int[] nums, int k) {
        // dp[i,j] 表示前i个元素，和为j的能量数
        int n = nums.length;
        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 0; j--) {
                dp[i + 1][j] = (2 * dp[i][j] + (j >= nums[i] ? dp[i][j - nums[i]] : 0)) % M;
            }
        }
        return (int) dp[n][k];
    }
}
