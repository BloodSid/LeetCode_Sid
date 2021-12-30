package leetcode.editor.cn;

import java.util.*;

/**
 * 在排序数组中查找数字 I
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-30 20:51:23
 */
public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int low = 0, high = nums.length - 1;
        int m = 0;
        while (low <= high) {
            m = (low + high) >>> 1;
            if (nums[m] == target) {
                break;
            } else if (nums[m] > target) {
                high = m - 1;
            } else {
                low = m + 1;
            }
        }
        if (nums[m] != target) {
            return 0;
        }

        int start = m, end = m;
        while (start > 0 && nums[start - 1] == target) start--;
        while (end < nums.length - 1 && nums[end + 1] == target) end++;
        return end - start + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
