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
    HashMap<TreeNode, Integer> depth = new HashMap<>();

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);
        int left = root.left == null ? 0 : depth.get(root.left);
        int right = root.right == null ? 0 : depth.get(root.right);
        depth.put(root, Math.max(left, right) + 1);
        return isLeftBalanced && isRightBalanced && Math.abs(left - right) <= 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
