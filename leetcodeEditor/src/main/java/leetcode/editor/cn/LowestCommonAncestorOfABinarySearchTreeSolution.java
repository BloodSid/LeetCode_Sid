package leetcode.editor.cn;

import binaryTree.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-09 16:32:33
 */
public class LowestCommonAncestorOfABinarySearchTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int v1 = p.val;
        int v2 = q.val;
        if (v1 > v2) {
            int t = v1;
            v1 = v2;
            v2 = t;
        }
        while (root != null) {
            if (root.val < v1) {
                root = root.right;
            } else if (root.val > v2) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
