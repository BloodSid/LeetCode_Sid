package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-18 17:04:57
 */
public class BinaryTreeZigzagLevelOrderTraversalSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean toLeft = false;
        while (!queue.isEmpty()) {
            Deque<Integer> line = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (toLeft) {
                    line.offerFirst(curr.val);
                } else {
                    line.offerLast(curr.val);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            toLeft = !toLeft;
            ans.add(new LinkedList<>(line));
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
