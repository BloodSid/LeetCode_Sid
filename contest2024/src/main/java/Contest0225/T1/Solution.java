package Contest0225.T1;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2024-02-25 10:31
 */
public class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int num : nums) {
            f.merge(num, 1, Integer::sum);
            if (f.get(num) > 2) return false;
        }
        return true;
    }
}
