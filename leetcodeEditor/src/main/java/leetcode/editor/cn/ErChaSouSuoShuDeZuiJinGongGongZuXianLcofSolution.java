package leetcode.editor.cn;

import binaryTree.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-14 12:52:22
 */
public class ErChaSouSuoShuDeZuiJinGongGongZuXianLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int v1 = Math.min(p.val, q.val);
        int v2 = p.val == v1 ? q.val : p.val;
        while (true) {
            if (root.val > v2) {
                root = root.left;
            } else if (root.val < v1) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
