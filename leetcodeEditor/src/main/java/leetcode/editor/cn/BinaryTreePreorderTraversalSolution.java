package leetcode.editor.cn;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
