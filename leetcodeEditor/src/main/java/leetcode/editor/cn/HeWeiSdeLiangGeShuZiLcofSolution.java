package leetcode.editor.cn;

import java.util.*;

/**
 * 和为s的两个数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-09 00:19:06
 */
public class HeWeiSdeLiangGeShuZiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] < target) {
                l++;
            } else if (nums[l] + nums[r] > target) {
                r--;
            } else {
                return new int[]{nums[l], nums[r]};
            }
        }
        return new int[]{};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
