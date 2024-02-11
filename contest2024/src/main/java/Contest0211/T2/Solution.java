package Contest0211.T2;

/**
 * @author IronSid
 * @since 2024-02-11 10:03
 */
public class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int m = pattern.length;
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - m; i++) {
            boolean flag = true;
            for (int offset = 0; offset < m; offset++) {
                if (Integer.signum(nums[i + offset + 1] - nums[i+offset]) != pattern[offset]) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans++;
        }
        return ans;
    }
}
