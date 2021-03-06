package leetcode.editor.cn;

import binaryTree.TreeNode;

/**
 * 对称二叉树
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-06 21:28:33
 */
public class SymmetricTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isTreeSymmetric(root.left, root.right);
    }

    boolean isTreeSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.val == b.val && isTreeSymmetric(a.left, b.right) && isTreeSymmetric(a.right, b.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
