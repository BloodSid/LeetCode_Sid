package leetcode.editor.cn;

import java.util.*;

/**
 * 至少是其他数字两倍的最大数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-13 13:34:00
 */
public class LargestNumberAtLeastTwiceOfOthersSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dominantIndex(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int p1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
                p1 = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return first >= second * 2 ? p1 : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
