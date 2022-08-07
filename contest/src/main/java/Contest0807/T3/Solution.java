package Contest0807.T3;

/**
 * @author IronSid
 * @since 2022-08-07 10:24
 */
public class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] && (i < 2 || dp[i - 2])) dp[i] = true;
            if (i >= 2 && nums[i] == nums[i - 1] && nums[i] == nums[i - 2] && (i < 3 || dp[i - 3])) dp[i] = true;
            if (i >= 2 && nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2 && (i < 3 || dp[i - 3])) dp[i] = true;
        }
        return dp[n - 1];
    }
}
