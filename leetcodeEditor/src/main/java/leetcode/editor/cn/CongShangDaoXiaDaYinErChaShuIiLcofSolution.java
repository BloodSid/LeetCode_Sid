package leetcode.editor.cn;

import binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 从上到下打印二叉树 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-01 20:54:38
 */
public class CongShangDaoXiaDaYinErChaShuIiLcofSolution {
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
