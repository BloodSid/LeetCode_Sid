package Contest0507.T1;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2023-05-07 10:32
 */
public class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            res[i] = set.size();
        }
        set.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            set.add(nums[i]);
            if (i > 0) res[i - 1] -= set.size();
        }
        return res;
    }
}