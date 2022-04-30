package leetcode.editor.cn;

/**
 * 寻找旋转排序数组中的最小值
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-19 09:32:37 
 */
public class FindMinimumInRotatedSortedArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l == nums.length ? nums[0] : nums[l];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
