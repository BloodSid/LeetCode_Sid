package leetcode.editor.cn;

import binaryTree.TreeNode;
import linkedList.ListNode;

/**
 * 二叉树中的列表
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-27 18:37:18 
 */
public class LinkedListInBinaryTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    boolean dfs(TreeNode node, ListNode head) {
        if (head == null) {
            return true;
        }
        if (node == null) {
            return false;
        }
        if (node.val != head.val) {
            return false;
        }
        return dfs(node.left, head.next) || dfs(node.right, head.next);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
