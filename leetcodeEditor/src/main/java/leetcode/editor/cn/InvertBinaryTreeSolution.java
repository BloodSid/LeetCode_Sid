package leetcode.editor.cn;

import java.util.*;

/**
 * 翻转二叉树
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-08 01:14:17
 */
public class InvertBinaryTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
