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
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
