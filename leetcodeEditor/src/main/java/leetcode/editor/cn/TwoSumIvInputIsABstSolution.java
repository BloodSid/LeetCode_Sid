package leetcode.editor.cn;

import java.util.*;

/**
 * 两数之和 IV - 输入 BST
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-09 16:50:46
 */
public class TwoSumIvInputIsABstSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    TreeNode root;
    int target;

    public boolean findTarget(TreeNode root, int target) {
        this.root = root;
        this.target = target;
        return findTarget(root);
    }

    boolean findTarget(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (2 * node.val != target && findValue(target - node.val)) {
            return true;
        }
        return findTarget(node.left) || findTarget(node.right);
    }

    boolean findValue(int val) {
        TreeNode p = root;
        while (p != null) {
            if (p.val == val) {
                return true;
            } else if (p.val < val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
