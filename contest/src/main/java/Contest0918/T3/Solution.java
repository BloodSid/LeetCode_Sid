package Contest0918.T3;

import binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * @author IronSid
 * @since 2022-09-18 10:28
 */
public class Solution {

    private ArrayDeque<TreeNode>[] dp;

    public TreeNode reverseOddLevels(TreeNode root) {
        dp = new ArrayDeque[20];
        dfs(root, 0);
        for (int i = 0; i < dp.length; i++) {
            ArrayDeque<TreeNode> cur = dp[i];
            ArrayDeque<TreeNode> next = dp[i + 1];
            if (next == null) break;
            Iterator<TreeNode> it1 = cur.iterator();
            Iterator<TreeNode> it2 = next.iterator();
            while (it1.hasNext()) {
                TreeNode parent = it1.next();
                parent.left = it2.next();
                parent.right = it2.next();
            }
        }
        return root;
    }

    void dfs(TreeNode node, int depth) {
        if (node == null) return;
        if (dp[depth] == null) dp[depth] = new ArrayDeque<>();
        if (depth % 2 == 0) {
            dp[depth].addLast(node);
        } else {
            dp[depth].addFirst(node);
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
