package leetcode.editor.cn;

import binaryTree.TreeNode;

/**
 * 二叉搜索树中的插入操作
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-08 23:50:35
 */
public class InsertIntoABinarySearchTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
