package leetcode.editor.cn;

import binaryTree.TreeNode;

/**
 * 二叉树的最大深度
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-06 21:28:38
 */
public class MaximumDepthOfBinaryTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
