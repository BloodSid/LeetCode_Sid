package leetcode.editor.cn;

import java.util.*;

/**
 * 三数之和
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-05 00:21:12 
 */
public class ThreeSumSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int num1 = 0; num1 < nums.length; num1++) {
            if (num1 > 0 && nums[num1] == nums[num1 - 1]) {
                continue;
            }
            int num3 = nums.length - 1;
            for (int num2 = num1 + 1; num2 < num3; num2++) {
                if (num2 > num1 + 1 && nums[num2] == nums[num2 - 1]) {
                    continue;
                }
                while (num2 < num3 && nums[num1] + nums[num2] + nums[num3] > 0) {
                    num3--;
                }
                if (num2 != num3 && nums[num1] + nums[num2] + nums[num3] == 0) {
                    ans.add(Arrays.asList(nums[num1], nums[num2], nums[num3]));
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
