package leetcode.editor.cn;

import java.util.*;

/**
 * 最小差值 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-07 23:22:49
 */
public class SmallestRangeIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        // 都变大或者都变小
        int range = nums[n - 1] - nums[0];
        // 为了让 range 最小，则可以把有序数组分成前后两个部分，前面的部分变大，后面的部分变小。枚举分割点
        for (int i = 0; i < n - 1; i++) {
            int a = nums[i], b = nums[i + 1];
            int high = Math.max(nums[n - 1] - k, a + k);
            int low = Math.min(nums[0] + k, b - k);
            range = Math.min(range, high - low);
        }
        return range;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
