package leetcode.editor.cn;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-19 09:27:47
 */
public class FindFirstAndLastPositionOfElementInSortedArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        // 长度零的数组 r 为 -1
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // nums 中没有 target
        if (r < 0 || nums[r] != target) {
            return res;
        }
        res[1] = r;
        // 第二次二分搜索
        l = 0;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        res[0] = l;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
