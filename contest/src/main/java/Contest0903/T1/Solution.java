package Contest0903.T1;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2022-09-03 22:32
 */
public class Solution {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (set.contains(sum)) return true;
            set.add(sum);
        }
        return false;
    }
}
