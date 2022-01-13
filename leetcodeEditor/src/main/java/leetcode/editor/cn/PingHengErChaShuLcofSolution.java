package leetcode.editor.cn;

import java.util.*;

/**
 * 平衡二叉树
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-13 13:33:54
 */
public class PingHengErChaShuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
    }

    int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
