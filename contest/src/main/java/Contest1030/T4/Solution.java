package Contest1030.T4;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-10-30 10:29
 */
public class Solution {

    public static final int N = (int) (1e5 + 10);
    // 记录所有子树的深度
    public static final int[] d = new int[N];
    // 每个节点到根节点的距离
    private List<List<TreeNode>> dis;


    public int[] treeQueries(TreeNode root, int[] queries) {
        dis = new ArrayList<>();
        int n = dfs(root, 0);
        // 对所有同一层的节点来说，删除其中一个节点的子树对其他节点不影响。删除最深的，树的高度变成次深的，删除其他的，树的高度不变
        int[] q = new int[n + 1];
        for (int i = 1; i < dis.size(); i++) {
            List<TreeNode> line = dis.get(i);
            line.sort((o1, o2) -> d[o2.val] - d[o1.val]);
            TreeNode first = line.get(0);
            int otherMax = line.size() == 1 ? -1 : d[line.get(1).val];
            q[first.val] = i + otherMax;
            for (int i1 = 1; i1 < line.size(); i1++) {
                TreeNode cur = line.get(i1);
                q[cur.val] = i + d[first.val];
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = q[queries[i]];
        }
        return res;
    }

    int dfs(TreeNode node, int depth) {
        if (node == null) return 0;
        if (dis.size() == depth) {
            dis.add(new ArrayList<>());
        }
        List<TreeNode> line = dis.get(depth);
        line.add(node);
        int l = dfs(node.left, depth + 1);
        int r = dfs(node.right, depth + 1);
        d[node.val] = Math.max(d(node.left), d(node.right)) + 1;
        return l + r + 1;
    }

    // 某个子树的深度
    int d(TreeNode node) {
        if (node == null) return -1;
        return d[node.val];
    }
}
