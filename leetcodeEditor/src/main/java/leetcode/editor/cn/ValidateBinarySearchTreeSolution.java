package leetcode.editor.cn;

import java.util.*;

/**
 * 验证二叉搜索树
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-09 11:09:15
 */
public class ValidateBinarySearchTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower || root.val >= upper) {
            return false;
        }
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
