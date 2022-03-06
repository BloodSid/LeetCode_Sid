package leetcode.editor.cn;

import binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二叉树的最小深度
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-19 21:32:09
 */
public class MinimumDepthOfBinaryTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.right == null && curr.left == null) return depth;
                if (curr.right != null) queue.offer(curr.right);
                if (curr.left != null) queue.offer(curr.left);
            }
        }
        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
