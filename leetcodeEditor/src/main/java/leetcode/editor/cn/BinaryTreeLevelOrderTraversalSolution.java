package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉树的层序遍历
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-06 21:28:37
 */
public class BinaryTreeLevelOrderTraversalSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> line = new ArrayList<>();
            result.add(line);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                line.add(cur.val);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
