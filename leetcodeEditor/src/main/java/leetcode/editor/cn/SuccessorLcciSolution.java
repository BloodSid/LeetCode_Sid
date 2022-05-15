package leetcode.editor.cn;

import binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 后继者
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-16 00:38:38 
 */
public class SuccessorLcciSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (p.right != null) {
            TreeNode next = p.right;
            while (next.left != null) next = next.left;
            return next;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (true) {
            stack.push(cur);
            if (p.val < cur.val) {
                cur = cur.left;
            } else if (p.val > cur.val) {
                cur = cur.right;
            } else {
                break;
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek().val > p.val) return stack.peek();
            stack.pop();
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
