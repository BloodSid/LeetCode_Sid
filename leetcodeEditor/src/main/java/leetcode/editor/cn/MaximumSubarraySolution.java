package leetcode.editor.cn;

import java.util.*;

/**
 * 最大子序和
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-02 12:54:51 
 */
public class MaximumSubarraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxSub = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            maxSub = Math.max(pre, maxSub);
        }
        return maxSub;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
