package Contest0911.T1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author IronSid
 * @since 2022-09-11 10:32
 */
public class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> f = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (num % 2 == 1) continue;
            int cnt = f.getOrDefault(num, 0) + 1;
            max = Math.max(max, cnt);
            f.put(num, cnt);
        }
        if (max == 0) return -1;
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : f.entrySet()) {
            if (entry.getValue() == max && entry.getKey() < res) res = entry.getKey();
        }
        return res;
    }
}
