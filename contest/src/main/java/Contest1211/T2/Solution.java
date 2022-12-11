package Contest1211.T2;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author IronSid
 * @since 2022-12-11 10:24
 */
public class Solution {
    public int longestSquareStreak(int[] nums) {
        // 2 <= nums[i] <= 1e5 该子序列最长为 5
        Arrays.sort(nums);
        int max = -1;
        HashMap<Integer, Integer> dp = new HashMap<>();
        for (int num : nums) {
            int pre = (int) Math.sqrt(num);
            if (pre * pre == num) {
                dp.put(num, dp.getOrDefault(pre, 0) + 1);
            } else {
                dp.put(num, 1);
            }
            max = Math.max(max, dp.get(num));
        }
        return max == 1 ? -1 : max;
    }
}
