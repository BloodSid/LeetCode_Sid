package leetcode.editor.cn;

import binaryTree.TreeNode;

/**
 * 二叉树的最近公共祖先
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-14 12:52:23
 */
public class ErChaShuDeZuiJinGongGongZuXianLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
