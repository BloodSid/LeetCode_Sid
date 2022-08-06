package leetcode.editor.cn;

/**
 * 有序数组中的单一元素
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-14 16:55:40
 */
public class SingleElementInASortedArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (mid != n - 1 && nums[mid] == nums[mid ^ 1]) l = mid + 1;
            else r = mid - 1;
        }
        return nums[l];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
