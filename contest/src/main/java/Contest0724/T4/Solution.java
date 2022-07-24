package Contest0724.T4;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2022-07-24 10:26
 */
public class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int num : nums) {
            f.put(num, f.getOrDefault(num, 0) + 1);
        }
        int[] bitCount = new int[32];
        for (Integer num : f.keySet()) {
            bitCount[Integer.bitCount(num)]++;
        }
        int[] sum = new int[32];
        for (int i = 31, t = 0; i >= 0; i--) {
            t += bitCount[i];
            sum[i] = t;
        }
        long res = 0;
        for (Integer num : f.keySet()) {
            int cur = Integer.bitCount(num);
            int other = Math.max(0, k - cur);
            if (other >= 32) continue;
            res += sum[other];
        }
        return res;
    }
}
