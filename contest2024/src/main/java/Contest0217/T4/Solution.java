package Contest0217.T4;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author IronSid
 * @since 2024-02-17 22:03
 */
public class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> dp = new HashMap<>();
        for (int x : nums) {
            // dp(x+1) = dp(x) + 1
            dp.put(x + 1, dp.getOrDefault(x, 0) + 1);
            // dp(x) = dp(x-1) + 1
            dp.put(x, dp.getOrDefault(x - 1, 0) + 1);
        }
        int max = 0;
        for (Integer i : dp.values()) {
            max = Math.max(max, i);
        }
        return max;
    }
}
