package Contest1112.T1;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author IronSid
 * @since 2022-11-12 21:44
 */
public class Solution {
    public int distinctAverages(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            set.add(nums[i] + nums[j]);
        }
        return set.size();
    }
}
