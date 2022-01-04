package leetcode.editor.cn;

import java.util.*;

/**
 * 连续子数组的最大和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-04 16:46:09 
 */
public class LianXuZiShuZuDeZuiDaHeLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int dp = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (dp < 0) {
                dp = num;
            } else {
                dp += num;
            }
            max = Math.max(max, dp);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
