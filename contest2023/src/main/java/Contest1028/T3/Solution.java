package Contest1028.T3;

import java.util.Arrays;
import java.util.List;

/**
 * @author IronSid
 * @since 2023-10-28 22:38
 */
public class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        // 和为key的子序列最大长度是value
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 1, target + 1, -1);
        for (Integer num : nums) {
            for (int k = target; k >= 0; k--) {
                if (dp[k] == -1) continue;
                int nk = num + k;
                if (nk > target) continue;
                dp[nk] = Math.max(dp[nk], dp[k] + 1);
            }
        }
        return dp[target];
    }
}
