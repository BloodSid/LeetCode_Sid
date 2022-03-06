package leetcode.editor.cn;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
