package Contest0731.T1;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2022-07-31 10:29
 */
public class Solution {
    public int minimumOperations(int[] nums) {
        int step = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        set.remove(0);
        step = set.size();
        return step;
    }
}
