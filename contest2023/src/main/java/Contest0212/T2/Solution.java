package Contest0212.T2;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2023-02-12 10:29
 */
public class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            while (l <= r) {
                int mid = l + r >> 1;
                if (nums[mid] + nums[i] >= lower) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            int j = l;
            l = i + 1;
            r = n - 1;
            while (l <= r) {
                int mid = l + r >> 1;
                if (nums[mid] + nums[i] <= upper) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            int k = r;
            res += Math.max(0, k - j + 1);
        }
        return res;
    }
}
