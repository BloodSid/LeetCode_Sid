package leetcode.editor.cn;

import java.util.*;

/**
 * 增量元素之间的最大差值
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-26 11:39:06
 */
public class MaximumDifferenceBetweenIncreasingElementsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int maxDIff = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            maxDIff = Math.max(maxDIff, nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return maxDIff > 0 ? maxDIff : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
