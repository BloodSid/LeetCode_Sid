package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉树的后序遍历
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-05 23:41:29
 */
public class BinaryTreePostorderTraversalSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> list;

    private void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        list = new LinkedList<>();
        postorder(root);
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
