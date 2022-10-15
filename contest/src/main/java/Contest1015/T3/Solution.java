package Contest1015.T3;

/**
 * @author IronSid
 * @since 2022-10-15 22:31
 */
public class Solution {
    public int minimizeArrayValue(int[] nums) {
        int res = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long avg = (sum - 1 + i + 1) / (i + 1);
            res = (int) Math.max(res, avg);
        }
        return res;
    }
}
