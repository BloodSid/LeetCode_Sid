package Contest0925.T2;

/**
 * @author IronSid
 * @since 2022-09-25 11:23
 */
public class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int res = 0;
        for (int i = 0, dp = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                dp++;
                res = Math.max(res, dp);
            } else {
                dp = 0;
            }
        }
        return res;
    }
}
