package leetcode.editor.cn;

import java.util.*;

/**
 * 数组中的第K个最大元素
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-23 07:36:54
 */
public class KthLargestElementInAnArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
