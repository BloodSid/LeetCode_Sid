package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉搜索树中的搜索
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-26 12:29:28 
 */
public class SearchInABinarySearchTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val < val) {
                root = root.right;
            } else if (root.val > val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
