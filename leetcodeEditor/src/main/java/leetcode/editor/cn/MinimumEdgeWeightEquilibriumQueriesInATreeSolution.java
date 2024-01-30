package leetcode.editor.cn;
//现有一棵由 n 个节点组成的无向树，节点按从 0 到 n - 1 编号。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 
//edges[i] = [ui, vi, wi] 表示树中存在一条位于节点 ui 和节点 vi 之间、权重为 wi 的边。 
//
// 另给你一个长度为 m 的二维整数数组 queries ，其中 queries[i] = [ai, bi] 。对于每条查询，请你找出使从 ai 到 bi 路
//径上每条边的权重相等所需的 最小操作次数 。在一次操作中，你可以选择树上的任意一条边，并将其权重更改为任意值。 
//
// 注意： 
//
// 
// 查询之间 相互独立 的，这意味着每条新的查询时，树都会回到 初始状态 。 
// 从 ai 到 bi的路径是一个由 不同 节点组成的序列，从节点 ai 开始，到节点 bi 结束，且序列中相邻的两个节点在树中共享一条边。 
// 
//
// 返回一个长度为 m 的数组 answer ，其中 answer[i] 是第 i 条查询的答案。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 7, edges = [[0,1,1],[1,2,1],[2,3,1],[3,4,2],[4,5,2],[5,6,2]], queries =
// [[0,3],[3,6],[2,6],[0,6]]
//输出：[0,0,1,3]
//解释：第 1 条查询，从节点 0 到节点 3 的路径中的所有边的权重都是 1 。因此，答案为 0 。
//第 2 条查询，从节点 3 到节点 6 的路径中的所有边的权重都是 2 。因此，答案为 0 。
//第 3 条查询，将边 [2,3] 的权重变更为 2 。在这次操作之后，从节点 2 到节点 6 的路径中的所有边的权重都是 2 。因此，答案为 1 。
//第 4 条查询，将边 [0,1]、[1,2]、[2,3] 的权重变更为 2 。在这次操作之后，从节点 0 到节点 6 的路径中的所有边的权重都是 2 。因此
//，答案为 3 。
//对于每条查询 queries[i] ，可以证明 answer[i] 是使从 ai 到 bi 的路径中的所有边的权重相等的最小操作次数。
// 
//
// 示例 2： 
// 
// 
//输入：n = 8, edges = [[1,2,6],[1,3,4],[2,4,6],[2,5,3],[3,6,6],[3,0,8],[7,0,2]], 
//queries = [[4,6],[0,4],[6,5],[7,4]]
//输出：[1,2,2,3]
//解释：第 1 条查询，将边 [1,3] 的权重变更为 6 。在这次操作之后，从节点 4 到节点 6 的路径中的所有边的权重都是 6 。因此，答案为 1 。
//第 2 条查询，将边 [0,3]、[3,1] 的权重变更为 6 。在这次操作之后，从节点 0 到节点 4 的路径中的所有边的权重都是 6 。因此，答案为 2
// 。
//第 3 条查询，将边 [1,3]、[5,2] 的权重变更为 6 。在这次操作之后，从节点 6 到节点 5 的路径中的所有边的权重都是 6 。因此，答案为 2
// 。
//第 4 条查询，将边 [0,7]、[0,3]、[1,3] 的权重变更为 6 。在这次操作之后，从节点 7 到节点 4 的路径中的所有边的权重都是 6 。因此
//，答案为 3 。
//对于每条查询 queries[i] ，可以证明 answer[i] 是使从 ai 到 bi 的路径中的所有边的权重相等的最小操作次数。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// edges.length == n - 1 
// edges[i].length == 3 
// 0 <= ui, vi < n 
// 1 <= wi <= 26 
// 生成的输入满足 edges 表示一棵有效的树 
// 1 <= queries.length == m <= 2 * 10⁴ 
// queries[i].length == 2 
// 0 <= ai, bi < n 
// 
//
// 👍 49 👎 0


import java.util.*;

/**
 * 边权重均等查询
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-01-26 23:19:35 
 */
public class MinimumEdgeWeightEquilibriumQueriesInATreeSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 权重范围
    private static final int W = 26;
    private int[][] pre;
    private List<int[]>[] map;
    private List<int[]>[] q;
    private int[] p;
    private int[] lca;
    private int[] vis;

    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        int m = queries.length;
        // 初始化图
        map = new List[n + 1];
        q = new List[n + 1];
        for (int i = 1; i <= n; i++) map[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) q[i] = new ArrayList<>();
        for (int[] edge : edges) {
            // 为了使用lca模板，边对齐到以1开始。权重对齐到以0开始
            int u = edge[0] + 1, v = edge[1] + 1, w = edge[2] - 1;
            map[v].add(new int[]{u, w});
            map[u].add(new int[]{v, w});
        }
        for (int i = 0; i < m; i++) {
            // 存储查询边在结果中的下标i
            int x = queries[i][0] + 1, y = queries[i][1] + 1;
            q[x].add(new int[]{y, i});
            q[y].add(new int[]{x, i});
        }
        // 并查集
        p = new int[n + 1];
        // 权重频数前缀和
        pre = new int[n + 1][];
        dfs(1,0, 0);
        lca = new int[m];
        vis = new int[n + 1];
        // 离线 tarjan 算法找 lca
        tarjan(1);
        // 计算结果
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int a = queries[i][0] + 1, b = queries[i][1] + 1;
            int lc = lca[i];
            // 计算 a -> lca -> b 的频数
            int max = 0, sum = 0;
            for (int j = 0; j < W; j++) {
                int f = pre[a][j] + pre[b][j] - 2 * pre[lc][j];
                sum += f;
                max = Math.max(max, f);
            }
            // 和减最大值即为结果
            res[i] = sum - max;
        }
        return res;
    }

    private void dfs(int cur, int prt, int weight) {
        if (prt == 0) {
            pre[cur] = new int[W];
        } else {
            pre[cur] = pre[prt].clone();
            pre[cur][weight]++;
        }
        for (int[] a : map[cur]) {
            int nxt = a[0], w = a[1];
            if (nxt == prt) continue;
            dfs(nxt, cur, w);
        }
    }

    private void tarjan(int cur) {
        // 遍历到某个结点的时候，认为这个结点的根结点就是它本身
        p[cur] = cur;
        vis[cur] = 1;
        for (int[] a : map[cur]) {
            int nxt = a[0];
            if (vis[nxt] != 0) continue;
            tarjan(nxt);
            // nxt 为根节点的子树全部遍历完毕了以后，再将nxt的根节点设置为cur, 相当于把该子树合并到cur
            p[nxt] = cur;
        }
        for (int[] a : q[cur]) {
            int y = a[0], i = a[1];
            // 如果另一个节点已经访问过了，则更新查询边的 LCA 结果
            if (vis[y] == 1) {
                lca[i] = find(y);
            }
        }
    }

    int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
