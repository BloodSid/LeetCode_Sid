package Contest0415.T2;

/**
 * @author IronSid
 * @since 2023-04-15 22:30
 */
public class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] t = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            t[i] = nums[i] + max;
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += t[i];
            t[i] = sum;
        }
        return t;
    }
}