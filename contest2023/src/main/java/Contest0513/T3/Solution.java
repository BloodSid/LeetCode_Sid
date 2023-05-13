package Contest0513.T3;

/**
 * @author IronSid
 * @since 2023-05-13 22:29
 */
public class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        // 前后缀分解
        long[] p = new long[n], s = new long[n];
        long t = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            t |= nums[i];
            p[i + 1] = t;
        }
        t = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            t |= nums[i];
            s[i - 1] = t;
        }
        long max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, p[i] | ((long) nums[i] << k) | s[i]);
        }
        return max;
    }
}
