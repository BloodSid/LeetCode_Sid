package leetcode.editor.cn;

import java.util.*;

/**
 * 从上到下打印二叉树
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-01 20:29:47
 */
public class CongShangDaoXiaDaYinErChaShuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        int[] buffer = new int[1050];
        int cnt = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            buffer[cnt] = cur.val;
            cnt++;
        }
        return Arrays.copyOfRange(buffer, 0, cnt);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
