package Contest1209.T3;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2023-12-09 22:16
 */
public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int i = 0, j = 0; i < n; ) {
            int add = nums[i];
            f.merge(add, 1, Integer::sum);
            i++;
            while (j < i && f.getOrDefault(add, 0) > k) {
                f.merge(nums[j], -1, Integer::sum);
                j++;
            }
            res = Math.max(res, i - j);
        }
        return res;
    }
}
