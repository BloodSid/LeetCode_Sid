package leetcode.editor.cn;
//你在一个城市里，城市由 n 个路口组成，路口编号为 0 到 n - 1 ，某些路口之间有 双向 道路。输入保证你可以从任意路口出发到达其他任意路口，且任意两
//个路口之间最多有一条路。 
//
// 给你一个整数 n 和二维整数数组 roads ，其中 roads[i] = [ui, vi, timei] 表示在路口 ui 和 vi 之间有一条需要花费
// timei 时间才能通过的道路。你想知道花费 最少时间 从路口 0 出发到达路口 n - 1 的方案数。 
//
// 请返回花费 最少时间 到达目的地的 路径数目 。由于答案可能很大，将结果对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
// 输入：n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2
//,5,1],[0,4,5],[4,6,2]]
//输出：4
//解释：从路口 0 出发到路口 6 花费的最少时间是 7 分钟。
//四条花费 7 分钟的路径分别为：
//- 0 ➝ 6
//- 0 ➝ 4 ➝ 6
//- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
//- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
// 
//
// 示例 2： 
//
// 输入：n = 2, roads = [[1,0,10]]
//输出：1
//解释：只有一条从路口 0 到路口 1 的路，花费 10 分钟。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n - 1 <= roads.length <= n * (n - 1) / 2 
// roads[i].length == 3 
// 0 <= ui, vi <= n - 1 
// 1 <= timei <= 10⁹ 
// ui != vi 
// 任意两个路口之间至多有一条路。 
// 从任意路口出发，你能够到达其他任意路口。 
// 
//
// 👍 105 👎 0


import java.util.*;

/**
 * 到达目的地的方案数
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-03-05 13:45:47 
 */
public class NumberOfWaysToArriveAtDestinationSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int M = (int) (1e9 + 7);
    public static final long INF = Long.MAX_VALUE / 2;

    public int countPaths(int n, int[][] roads) {
        // 建图
        long[][] g = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], INF);
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1], weight = road[2];
            g[u][v] = g[v][u] = weight;
        }

        long[] dis = new long[n];
        Arrays.fill(dis, INF);
        dis[0] = 0;
        // f[i]表示到达i的步数
        long[] f = new long[n];
        f[0] = 1;
        boolean[] done = new boolean[n];
        while (true) {
            int x = -1;
            // 取 dis[i] 的最小值
            for (int i = 0; i < n; i++) {
                if (!done[i] && (x < 0 || dis[i] < dis[x])) {
                    x = i;
                }
            }
            if (x == n - 1) {
                // 不可能找到比 dis[n-1] 更短，或者一样短的最短路了（注意本题边权都是正数）
                return (int) f[n - 1];
            }
            // // 最短路长度已确定（无法变得更小）
            done[x] = true;
            for (int y = 0; y < n; y++) {
                // 更新 x 的邻居的最短路
                long newDis = dis[x] + g[x][y];
                if (newDis < dis[y]) {
                    dis[y] = newDis;
                    f[y] = f[x];
                } else if (newDis == dis[y]) {
                    f[y] = (f[y] + f[x]) % M;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
