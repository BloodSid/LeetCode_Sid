package Contest1015.T3;

/**
 * @author IronSid
 * @since 2022-10-15 22:31
 */
public class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long right = 0;
        for (int num : nums) {
            sum += num;
            right = Math.max(right, num);
        }
        long left = (sum - 1 + n) / n;
        while (left <= right) {
            long mid = left + right >> 1;
            long gap = 0;
            int i;
            for (i = 0; i < n; i++) {
                if (nums[i] < mid) {
                    gap += mid - nums[i];
                } else {
                    gap -= nums[i] - mid;
                }
                if (gap < 0) break;
            }
            if (i == n) right = mid - 1;
            else left = mid + 1;
        }
        return (int) left;
    }
}
