package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉树的前序遍历
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-05 23:41:10
 */
public class BinaryTreePreorderTraversalSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> list;

    public List<Integer> preorderTraversal(TreeNode root) {
        list = new LinkedList<>();
        preorder(root);
        return list;
    }

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
