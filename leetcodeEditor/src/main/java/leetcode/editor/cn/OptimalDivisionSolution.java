package leetcode.editor.cn;

import java.util.*;

/**
 * 最优除法
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-27 00:14:01
 */
public class OptimalDivisionSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append('/').append('(');
        for (int i = 1; i < nums.length - 1; i++) {
            sb.append(nums[i]).append('/');
        }
        sb.append(nums[nums.length - 1]).append(')');
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
