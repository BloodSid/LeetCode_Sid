package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉搜索树迭代器
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-20 18:31:53
 */
public class BinarySearchTreeIteratorSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class BSTIterator {
    Deque<TreeNode> stack;
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        curr = root;
    }

    public int next() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        int val = curr.val;
        curr = curr.right;
        return val;
    }

    public boolean hasNext() {
        return curr != null || !stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
