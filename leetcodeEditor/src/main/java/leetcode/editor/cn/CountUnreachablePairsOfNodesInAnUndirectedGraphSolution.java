package leetcode.editor.cn;
//给你一个整数 n ，表示一张 无向图 中有 n 个节点，编号为 0 到 n - 1 。同时给你一个二维整数数组 edges ，其中 edges[i] = [
//ai, bi] 表示节点 ai 和 bi 之间有一条 无向 边。 
//
// 请你返回 无法互相到达 的不同 点对数目 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 3, edges = [[0,1],[0,2],[1,2]]
//输出：0
//解释：所有点都能互相到达，意味着没有点对无法互相到达，所以我们返回 0 。
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
//输出：14
//解释：总共有 14 个点对互相无法到达：
//[[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6]
//,[5,6]]
//所以我们返回 14 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 0 <= edges.length <= 2 * 10⁵ 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// 不会有重复边。 
// 
// 👍 2 👎 0


import java.util.*;

/**
 * 统计无向图中无法互相到达点对数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-27 18:36:59 
 */
public class CountUnreachablePairsOfNodesInAnUndirectedGraphSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int n;
    private List[] map;
    private boolean[] visited;

    public long countPairs(int n, int[][] edges) {
        this.n = n;
        visited = new boolean[n];
        long res = 0;
        map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList();
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            map[x].add(y);
            map[y].add(x);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int size = dfs(i);
                res += (long) (n - size) * size;
            }
        }
        return res / 2;
    }

    int dfs(int node) {
        visited[node] = true;
        int size = 1;
        for (Object o : map[node]) {
            int child = (int) o;
            if (!visited[child]) {
                size += dfs(child);
            }
        }
        return size;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
