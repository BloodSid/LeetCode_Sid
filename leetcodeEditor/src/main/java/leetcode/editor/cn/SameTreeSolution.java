package leetcode.editor.cn;

import java.util.*;

/**
 * 相同的树
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-28 23:08:32
 */
public class SameTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
