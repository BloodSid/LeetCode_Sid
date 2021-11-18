package leetcode.editor.cn;

import java.util.*;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-18 16:51:13
 */
public class ConvertSortedArrayToBinarySearchTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(0, nums.length - 1, nums);
    }

    TreeNode sortedArrayToBST(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = start + end >> 1;
        return new TreeNode(nums[mid], sortedArrayToBST(start, mid - 1, nums),
                sortedArrayToBST(mid + 1, end, nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
