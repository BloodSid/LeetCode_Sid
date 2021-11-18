package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-18 17:04:57
 */
public class BinaryTreeZigzagLevelOrderTraversalSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        boolean toLeft = false;
        while (!stack.isEmpty()) {
            Deque<TreeNode> tem = new LinkedList<>();
            List<Integer> line = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode right = stack.peek().right;
                TreeNode left = stack.peek().left;
                if (toLeft) {
                    if (right != null) {
                        tem.push(right);
                    }
                    if (left != null) {
                        tem.push(left);
                    }
                } else {
                    if (left != null) {
                        tem.push(left);
                    }
                    if (right != null) {
                        tem.push(right);
                    }
                }
                line.add(stack.pop().val);
            }
            stack = tem;
            toLeft = !toLeft;
            ans.add(line);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
