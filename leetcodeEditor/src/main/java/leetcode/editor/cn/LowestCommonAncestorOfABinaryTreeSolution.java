package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉树的最近公共祖先
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-21 18:37:28
 */
public class LowestCommonAncestorOfABinaryTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
