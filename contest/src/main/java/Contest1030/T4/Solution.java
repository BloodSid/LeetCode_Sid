package Contest1030.T4;

import binaryTree.TreeNode;

/**
 * @author IronSid
 * @since 2022-10-30 10:29
 */
public class Solution {

    public static final int N = (int) (1e5 + 10);
    // 记录所有子树的深度
    public static final int[] d = new int[N];
    public static final int[] res = new int[N];


    public int[] treeQueries(TreeNode root, int[] queries) {
        getDepth(root);
        dfs(root, 0, 0);
        for (int i = 0; i < queries.length; i++) {
            queries[i] = res[queries[i]];
        }
        return queries;
    }

    // 计算所有子树的深度
    int getDepth(TreeNode node) {
        if (node == null) return 0;
        int l = getDepth(node.left);
        int r = getDepth(node.right);
        int depth = Math.max(l, r) + 1;
        d[node.val] = depth;
        return d[node.val];
    }

    // restH 表示去除当前子树后剩余部分的高度
    void dfs(TreeNode o, int depth, int restH) {
        if (o == null) return;
        res[o.val] = restH;
        dfs(o.left, depth + 1, Math.max(restH, depth + (o.right == null ? 0 : d[o.right.val])));
        dfs(o.right, depth + 1, Math.max(restH, depth + (o.left == null ? 0 : d[o.left.val])));
    }
}
