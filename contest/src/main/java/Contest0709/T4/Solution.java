package Contest0709.T4;

/**
 * @author IronSid
 * @since 2022-07-09 22:21
 */
class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        int limit = 0;
        for (int len = 1; len <= n; len++) {
            int t = threshold / len + 1;
            if (t == limit) continue;
            if (t < 1) break;
            limit = t;
            int last = -1;
            int i = 0;
            for (; i < nums.length; i++) {
                if (nums[i] < limit) {
                    if (i - last - 1 >= len) return len;
                    last = i;
                }
            }
            if (n - 1 - last >= len) return len;
        }
        return -1;
    }
}
