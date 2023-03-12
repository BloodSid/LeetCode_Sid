package leetcode.editor.cn;
//给你 n 个城市，编号为从 1 到 n 。同时给你一个大小为 n-1 的数组 edges ，其中 edges[i] = [ui, vi] 表示城市 ui 和
// vi 之间有一条双向边。题目保证任意城市之间只有唯一的一条路径。换句话说，所有城市形成了一棵 树 。 
//
// 一棵 子树 是城市的一个子集，且子集中任意城市之间可以通过子集中的其他城市和边到达。两个子树被认为不一样的条件是至少有一个城市在其中一棵子树中存在，但在另
//一棵子树中不存在。 
//
// 对于 d 从 1 到 n-1 ，请你找到城市间 最大距离 恰好为 d 的所有子树数目。 
//
// 请你返回一个大小为 n-1 的数组，其中第 d 个元素（下标从 1 开始）是城市间 最大距离 恰好等于 d 的子树数目。 
//
// 请注意，两个城市间距离定义为它们之间需要经过的边的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 4, edges = [[1,2],[2,3],[2,4]]
//输出：[3,4,0]
//解释：
//子树 {1,2}, {2,3} 和 {2,4} 最大距离都是 1 。
//子树 {1,2,3}, {1,2,4}, {2,3,4} 和 {1,2,3,4} 最大距离都为 2 。
//不存在城市间最大距离为 3 的子树。
// 
//
// 示例 2： 
//
// 
//输入：n = 2, edges = [[1,2]]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：n = 3, edges = [[1,2],[2,3]]
//输出：[2,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 15 
// edges.length == n-1 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// 题目保证 (ui, vi) 所表示的边互不相同。 
// 
//
// 👍 101 👎 0


import java.util.*;

/**
 * 统计子树中城市之间最大距离
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-03-12 16:36:15 
 */
public class CountSubtreesWithMaxDistanceBetweenCitiesSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int INF = (int) (1e9 + 7);
    private int[][] d;
    private int n;
    private int[] ans;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        d = new int[n][n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], INF);
        }
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
            addEdge(edge[1], edge[0]);
        }
        // Floyd 算法
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        ans = new int[n - 1];
        boolean[][] vis = new boolean[n][n];
        dfs(0, vis);
        return ans;
    }

    void addEdge(int i, int j) {
        // 节点下标改为从零算起
        i--;
        j--;
        d[i][j] = 1;
    }

    // 以该节点为根的所有
    List<Integer> dfs(int cur, boolean[][] vis) {
        List<Integer> subs = new ArrayList<>();
        subs.add(1 << cur);
        for (int child = 0; child < n; child++) {
            if (vis[cur][child] || d[cur][child] != 1) continue;
            vis[cur][child] = true;
            vis[child][cur] = true;
            // 和子结点的子树进行组合
            List<Integer> childSubs = dfs(child, vis);
            int size = subs.size();
            for (int i = 0; i < size; i++) {
                int s = subs.get(i);
                for (Integer c : childSubs) {
                    subs.add(s | c);
                }
            }
        }
        for (Integer sub : subs) {
            int maxD = 0;
            for (int x = 0; x < n; x++) {
                if ((sub >> x & 1) == 0) continue;
                for (int y = x + 1; y < n; y++) {
                    if ((sub >> y & 1) == 0) continue;
                    maxD = Math.max(maxD, d[x][y]);
                }
            }
            if (maxD > 0 && maxD != INF) ans[maxD - 1]++;
        }
        return subs;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
