package leetcode.editor.cn;

/**
 * 搜索旋转排序数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-19 09:32:29
 */
public class SearchInRotatedSortedArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) return mid;
            if (nums[l] <= nums[mid]) {
                // 若前半部分有序, 则可知前半部分元素的大小范围。target 在这个范围中则搜索前半，否则搜索后半。
                if (nums[l] <= target && nums[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 后半部分有序
                if (nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
