package leetcode.editor.cn;

import binaryTree.TreeNode;

/**
 * 根据二叉树创建字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-19 00:00:25 
 */
public class ConstructStringFromBinaryTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String tree2str(TreeNode root) {
        if (root.left == null && root.right == null) {
            return String.valueOf(root.val);
        }
        // 只有左子节点为空
        if (root.left == null) {
            return root.val + "()(" + tree2str(root.right) + ")";
        }
        // 只有右子节点为空
        if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        }
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
