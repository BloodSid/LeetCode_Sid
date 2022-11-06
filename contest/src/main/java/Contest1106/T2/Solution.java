package Contest1106.T2;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2022-11-06 10:10
 */
public class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> f = new HashMap<>();
        long sum = 0L;
        long max = 0L;
        for (int i = 0, j = 0; ; ) {
            if (j - i < k) {
                if (j == nums.length) break;
                int t = nums[j++];
                sum += t;
                f.put(t, f.getOrDefault(t, 0) + 1);
            } else {
                if (f.size() == k) {
                    max = Math.max(max, sum);
                }
                int t = nums[i++];
                sum -= t;
                if (f.get(t) == 1) f.remove(t);
                else f.put(t, f.get(t) - 1);
            }
        }
        return max;
    }
}
