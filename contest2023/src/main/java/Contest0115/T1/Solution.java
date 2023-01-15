package Contest0115.T1;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2023-01-15 10:20
 */
public class Solution {
    public int differenceOfSum(int[] nums) {
        int x = Arrays.stream(nums).sum();
        int y = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j > 0; j /= 10) {
                y += j % 10;
            }
        }
        return Math.abs(x - y);
    }
}
