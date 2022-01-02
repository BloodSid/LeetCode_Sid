package leetcode.editor.cn;

import java.util.*;

/**
 * 树的子结构
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-02 18:11:11
 */
public class ShuDeZiJieGouLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // 判断b是不是a的子树，即b的所有节点属于a，且位置相同
    boolean isSubTree(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        return a.val == b.val && isSubTree(a.left, b.left) && isSubTree(a.right, b.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
