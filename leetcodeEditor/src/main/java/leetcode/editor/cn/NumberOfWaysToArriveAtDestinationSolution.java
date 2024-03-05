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

    public int countPaths(int n, int[][] roads) {
        // 只有一个节点
        if (n == 1) {
            return 1;
        }

        long[][] f = new long[n][n];
        long[][] w = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], Long.MAX_VALUE / 2);
        }
        // 建图
        for (int[] road : roads) {
            int u = road[0], v = road[1], weight = road[2];
            f[u][v] = f[v][u] = weight;
            w[u][v] = w[v][u] = 1;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    long sum = f[i][k] + f[k][j];
                    if (sum < f[i][j]) {
                        f[i][j] = sum;
                        w[i][j] = w[i][k] * w[k][j] % M;
                    } else if (sum == f[i][j]) {
                        w[i][j] = (w[i][j] + w[i][k] * w[k][j]) % M;
                    }
                }
            }
        }
        return (int) w[0][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
