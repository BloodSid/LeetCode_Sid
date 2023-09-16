package Contest0916.T2;

import java.util.HashMap;
import java.util.List;

/**
 * @author IronSid
 * @since 2023-09-16 22:21
 */
public class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        HashMap<Integer, Integer> f = new HashMap<>();
        for (Integer num : nums) {
            f.merge(num, 1, Integer::sum);
        }
        int max = 0;
        for (Integer value : f.values()) {
            if (value > max) max = value;
        }
        // 如果某元素出现次数过半
        int n = nums.size();
        if (max > n / 2) return max - (n - max);
        return n % 2;
    }
}