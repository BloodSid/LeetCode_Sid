package Contest0723.T2;

/**
 * @author IronSid
 * @since 2022-07-23 22:29
 */
public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int dp = 0;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                dp++;
            } else {
                dp = 0;
            }
            res += dp;
        }
        return res;
    }
}
