package Contest0319_1.T2;

import java.util.Arrays;

public class Solution {
    public int maximizeGreatness(int[] nums) {
        Arrays.sort(nums);
        int fast = 0;
        int slow = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] > nums[slow]) {
                slow++;
            }
        }
        return slow;
    }
}
