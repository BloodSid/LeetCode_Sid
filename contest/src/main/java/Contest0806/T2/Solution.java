package Contest0806.T2;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2022-08-06 19:15
 */
public class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int d = i - nums[i];
            f.put(d, f.getOrDefault(d, 0) + 1);
        }
        int n = nums.length;
        long sum = 0;
        for (Integer value : f.values()) {
            long cnt = value;
            sum += (n - cnt) * cnt;
        }
        return sum >> 1;
    }
}
