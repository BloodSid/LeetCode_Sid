package leetcode.editor.cn;

import binaryTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的右视图
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-19 16:54:57
 */
public class BinaryTreeRightSideViewSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int val = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                val = curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            ans.add(val);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
