package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉树的中序遍历
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-05 23:36:46
 */
public class BinaryTreeInorderTraversalSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> list;

    public List<Integer> inorderTraversal(TreeNode root) {
        list = new LinkedList<>();
        inorder(root);
        return list;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
