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
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int index = 0;
        TreeNode cur;
        while (index != queue.size()) {
            cur = queue.get(index);
            index++;
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        int[] result = new int[queue.size()];
        index = 0;
        for (TreeNode treeNode : queue) {
            result[index] = treeNode.val;
            index++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
