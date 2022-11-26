package leetcode.editor.cn;
//给你一个无向图（原始图），图中有 n 个节点，编号从 0 到 n - 1 。你决定将图中的每条边 细分 为一条节点链，每条边之间的新节点数各不相同。 
//
// 图用由边组成的二维数组 edges 表示，其中 edges[i] = [ui, vi, cnti] 表示原始图中节点 ui 和 vi 之间存在一条边，
//cnti 是将边 细分 后的新节点总数。注意，cnti == 0 表示边不可细分。 
//
// 要 细分 边 [ui, vi] ，需要将其替换为 (cnti + 1) 条新边，和 cnti 个新节点。新节点为 x1, x2, ..., xcnti ，
//新边为 [ui, x1], [x1, x2], [x2, x3], ..., [xcnti+1, xcnti], [xcnti, vi] 。 
//
// 现在得到一个 新的细分图 ，请你计算从节点 0 出发，可以到达多少个节点？如果节点间距离是 maxMoves 或更少，则视为 可以到达 。 
//
// 给你原始图和 maxMoves ，返回 新的细分图中从节点 0 出发 可到达的节点数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：edges = [[0,1,10],[0,2,1],[1,2,2]], maxMoves = 6, n = 3
//输出：13
//解释：边的细分情况如上图所示。
//可以到达的节点已经用黄色标注出来。
// 
//
// 示例 2： 
//
// 
//输入：edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], maxMoves = 10, n = 4
//输出：23
// 
//
// 示例 3： 
//
// 
//输入：edges = [[1,2,4],[1,4,5],[1,3,1],[2,3,4],[3,4,5]], maxMoves = 17, n = 5
//输出：1
//解释：节点 0 与图的其余部分没有连通，所以只有节点 0 可以到达。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= edges.length <= min(n * (n - 1) / 2, 10⁴) 
// edges[i].length == 3 
// 0 <= ui < vi < n 
// 图中 不存在平行边 
// 0 <= cnti <= 10⁴ 
// 0 <= maxMoves <= 10⁹ 
// 1 <= n <= 3000 
// 
// 👍 137 👎 0


import java.util.*;


/**
 * 细分图中的可到达节点
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-11-26 23:52:51 
 */
public class ReachableNodesInSubdividedGraphSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int INF = (int) (1e9 + 7);
    private List<int[]>[] map;

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        map = new List[n];
        // 建图
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            add(e[0], e[1], e[2] + 1);
            add(e[1], e[0], e[2] + 1);
        }
        // 迪杰斯特拉算法
        // 表示该点是否已经找到最短路
        boolean[] u = new boolean[n];
        // 最短路的长度
        int[] dist = new int[n];
        Arrays.fill(dist, 1, n, INF);
        // {node, dist}
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int node = poll[0]; int d = poll[1];
            if (u[node]) continue;
            // if (d > maxMoves) break;
            u[node] = true;
            dist[node] = d;
            for (int[] ne : map[node]) {
                int next = ne[0], val = ne[1];
                if (u[next]) continue;
                pq.offer(new int[]{next, d + val});
            }
        }
        int res = 0;
        for (int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1], v = edge[2];
            int v1 = 0, v2 = 0;
            if (dist[n1] < maxMoves) v1 = maxMoves - dist[n1];
            if (dist[n2] < maxMoves) v2 = maxMoves - dist[n2];
            res += Math.min(v, v1 + v2);
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] <= maxMoves) res++;
        }
        return res;
    }

    void add(int f, int t, int v) {
        map[f].add(new int[]{t, v});
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
