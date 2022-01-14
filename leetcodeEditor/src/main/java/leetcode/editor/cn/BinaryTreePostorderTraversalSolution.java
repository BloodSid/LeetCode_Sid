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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root, pre = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            // 如果该节点没有右子树，或者右子树已经加入结果，则该节点加入结果
            if (cur.right == null || cur.right == pre) {
                list.add(cur.val);
                pre = cur;
                cur = null;
            } else {
                stack.push(cur);
                cur = cur.right;
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
