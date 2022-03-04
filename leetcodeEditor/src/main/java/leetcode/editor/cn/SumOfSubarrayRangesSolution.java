package leetcode.editor.cn;

import java.util.*;

/**
 * 子数组范围和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-04 15:14:03
 */
public class SumOfSubarrayRangesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += max - min;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
