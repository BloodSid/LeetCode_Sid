package leetcode.editor.cn;

import java.util.*;

/**
 * 从上到下打印二叉树 III
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-01 20:54:44
 */
public class CongShangDaoXiaDaYinErChaShuIiiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        int lineIndex = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> line = new LinkedList<>();
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
                if (lineIndex % 2 == 0) {
                    line.addLast(cur.val);
                } else {
                    line.addFirst(cur.val);
                }
            }
            lineIndex++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
