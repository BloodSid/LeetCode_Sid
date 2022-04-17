package leetcode.editor.cn;

import binaryTree.TreeNode;

/**
 * 二叉搜索树染色
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-17 10:10:22
 */
public class QO5KpGSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int cnt;
    int[][] ops;

    public int getNumber(TreeNode root, int[][] ops) {
        this.ops = ops;
        dfs(root);
        return cnt;
    }

    void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (isRed(node.val)) {
            cnt++;
        }
        dfs(node.right);
    }

    boolean isRed(int val) {
        for (int i = ops.length - 1; i >= 0; i--) {
            if (val >= ops[i][1] && val <= ops[i][2]) {
                return ops[i][0] == 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
