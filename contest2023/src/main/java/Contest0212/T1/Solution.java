package Contest0212.T1;

/**
 * @author IronSid
 * @since 2023-02-12 10:29
 */
public class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int n = nums.length;
        long res = 0;
        int i = 0, j = n - 1;
        for (; i < j; i++, j--) {
            res += Long.parseLong("" + nums[i] + nums[j]);
        }
        if (i == j) {
            res += nums[i];
        }
        return res;
    }

}
