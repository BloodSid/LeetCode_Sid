package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉树的最近公共祖先
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-21 18:37:28
 */
public class LowestCommonAncestorOfABinaryTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Deque<TreeNode> stack;
    TreeNode p;
    TreeNode q;
    List<TreeNode> pStack;
    List<TreeNode> qStack;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        stack = new LinkedList<>();
        this.p = p;
        this.q = q;
        dfs(root);
        int min = Math.min(pStack.size(), qStack.size());
        for (int i = pStack.size() - min, j = qStack.size() - min; i < pStack.size(); i++, j++) {
            if (pStack.get(i) == qStack.get(j)) {
                return pStack.get(i);
            }
        }
        return root;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        stack.push(root);
        if (root == p) {
            pStack = new ArrayList<>(stack);
        }
        if (root == q) {
            qStack = new ArrayList<>(stack);
        }
        dfs(root.right);
        dfs(root.left);
        stack.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
