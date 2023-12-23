package Contest1223.T2;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2023-12-23 22:24
 */
public class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] >= sum - nums[i]) {
                sum -= nums[i];
            } else {
                break;
            }
        }
        return sum != 0 ? sum : -1;
    }
}
