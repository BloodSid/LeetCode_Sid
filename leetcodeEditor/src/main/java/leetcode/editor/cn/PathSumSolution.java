package leetcode.editor.cn;

import binaryTree.TreeNode;

/**
 * 路径总和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-08 01:22:05
 */
public class PathSumSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
