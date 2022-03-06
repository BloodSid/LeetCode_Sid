package leetcode.editor.cn;

import binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉搜索树的第k大节点
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-10 09:42:58
 */
public class ErChaSouSuoShuDeDiKdaJieDianLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.left;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
