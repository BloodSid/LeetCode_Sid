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
        return getDepth(root) >= 0;
    }

    // 若不平衡，返回-1；若平衡返回深度
    int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        // 若节点的子树不平衡，则该节点不平衡
        if (leftDepth == -1 || rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
