package leetcode.editor.cn;
//给你一个二维数组 edges 表示一个 n 个点的无向图，其中 edges[i] = [ui, vi, lengthi] 表示节点 ui 和节点 vi 之间
//有一条需要 lengthi 单位时间通过的无向边。 
//
// 同时给你一个数组 disappear ，其中 disappear[i] 表示节点 i 从图中消失的时间点，在那一刻及以后，你无法再访问这个节点。 
//
// 注意，图有可能一开始是不连通的，两个节点之间也可能有多条边。 
//
// 请你返回数组 answer ，answer[i] 表示从节点 0 到节点 i 需要的 最少 单位时间。如果从节点 0 出发 无法 到达节点 i ，那么 
//answer[i] 为 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
// 输入：n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,1,5] 
// 
//
// 输出：[0,-1,4] 
//
// 解释： 
//
// 我们从节点 0 出发，目的是用最少的时间在其他节点消失之前到达它们。 
//
// 
// 对于节点 0 ，我们不需要任何时间，因为它就是我们的起点。 
// 对于节点 1 ，我们需要至少 2 单位时间，通过 edges[0] 到达。但当我们到达的时候，它已经消失了，所以我们无法到达它。 
// 对于节点 2 ，我们需要至少 4 单位时间，通过 edges[2] 到达。 
// 
//
// 示例 2： 
//
// 
//
// 
// 输入：n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,3,5] 
// 
//
// 输出：[0,2,3] 
//
// 解释： 
//
// 我们从节点 0 出发，目的是用最少的时间在其他节点消失之前到达它们。 
//
// 
// 对于节点 0 ，我们不需要任何时间，因为它就是我们的起点。 
// 对于节点 1 ，我们需要至少 2 单位时间，通过 edges[0] 到达。 
// 对于节点 2 ，我们需要至少 3 单位时间，通过 edges[0] 和 edges[1] 到达。 
// 
//
// 示例 3： 
//
// 
// 输入：n = 2, edges = [[0,1,1]], disappear = [1,1] 
// 
//
// 输出：[0,-1] 
//
// 解释： 
//
// 当我们到达节点 1 的时候，它恰好消失，所以我们无法到达节点 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5 * 10⁴ 
// 0 <= edges.length <= 10⁵ 
// edges[i] == [ui, vi, lengthi] 
// 0 <= ui, vi <= n - 1 
// 1 <= lengthi <= 10⁵ 
// disappear.length == n 
// 1 <= disappear[i] <= 10⁵ 
// 
//
// 👍 4 👎 0


import java.util.*;

/**
 * 访问消失节点的最少时间
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-07-18 00:20:38 
 */
public class MinimumTimeToVisitDisappearingNodesSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int INF = Integer.MAX_VALUE;

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        // 邻接表建图
        List<int[]>[] map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            map[u].add(new int[]{v, w});
            map[v].add(new int[]{u, w});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        // {节点，距离}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int x = p[0], d = p[1];
            if (d > dist[x]) { // x 之前出堆过
                continue;
            }
            dist[x] = d;
            for (int[] e : map[x]) {
                int y = e[0];
                int nd = e[1] + d;
                // 下一个节点已经消失了就无法到达
                if (disappear[y] <= nd) continue;
                if (nd < dist[y]) {
                    dist[y] = nd;
                    pq.offer(new int[]{y, nd});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == INF) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
