package Contest1016.T1;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2022-10-16 11:12
 */
public class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = -1;
        for (int num : nums) {
            if (num > 0 && set.contains(-num)) max = Math.max(max, num);
        }
        return max;
    }
}
