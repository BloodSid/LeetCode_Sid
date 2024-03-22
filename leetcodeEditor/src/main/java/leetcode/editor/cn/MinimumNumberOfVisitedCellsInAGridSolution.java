package leetcode.editor.cn;
//给你一个下标从 0 开始的 m x n 整数矩阵 grid 。你一开始的位置在 左上角 格子 (0, 0) 。 
//
// 当你在格子 (i, j) 的时候，你可以移动到以下格子之一： 
//
// 
// 满足 j < k <= grid[i][j] + j 的格子 (i, k) （向右移动），或者 
// 满足 i < k <= grid[i][j] + i 的格子 (k, j) （向下移动）。 
// 
//
// 请你返回到达 右下角 格子 (m - 1, n - 1) 需要经过的最少移动格子数，如果无法到达右下角格子，请你返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[3,4,2,1],[4,2,3,1],[2,1,0,0],[2,4,0,0]]
//输出：4
//解释：上图展示了到达右下角格子经过的 4 个格子。
// 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[3,4,2,1],[4,2,1,1],[2,1,1,0],[3,4,1,0]]
//输出：3
//解释：上图展示了到达右下角格子经过的 3 个格子。
// 
//
// 示例 3： 
//
// 
//
// 输入：grid = [[2,1,0],[1,0,0]]
//输出：-1
//解释：无法到达右下角格子。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10⁵ 
// 1 <= m * n <= 10⁵ 
// 0 <= grid[i][j] < m * n 
// grid[m - 1][n - 1] == 0 
// 
//
// 👍 64 👎 0


import java.util.*;

/**
 * 网格图中最少访问的格子数
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-03-22 23:47:50 
 */
public class MinimumNumberOfVisitedCellsInAGridSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int INF = Integer.MAX_VALUE;

    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 每一列的最小堆，存储 {经过的格子数，最远能到达的位置}
        PriorityQueue<int[]>[] colQ = new PriorityQueue[n];
        Arrays.setAll(colQ, i -> new PriorityQueue<int[]>((a, b) -> a[0] - b[0]));
        // 每一行的最小堆
        PriorityQueue<int[]>[] rowQ = new PriorityQueue[m];
        Arrays.setAll(rowQ, i -> new PriorityQueue<int[]>((a, b) -> a[0] - b[0]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 弹出无用数据
                PriorityQueue<int[]> row = rowQ[i], col = colQ[j];
                while (!row.isEmpty() && row.peek()[1] < j) {
                    row.poll();
                }
                while (!col.isEmpty() && col.peek()[1] < i) {
                    col.poll();
                }

                int step;
                if (i == 0 && j == 0) {
                    // 起点算一个格子
                    step = 1;
                } else {
                    step = INF;
                }
                // 分别计算从左边跳过来，从上边跳过来
                if (!row.isEmpty()) {
                    step = Math.min(step, row.peek()[0] + 1);
                }
                if (!col.isEmpty()) {
                    step = Math.min(step, col.peek()[0] + 1);
                }
                if (i == m - 1 && j == n - 1) {
                    return step != INF ? step : -1;
                }
                int g = grid[i][j];
                if (g > 0 && step != INF) {
                    row.offer(new int[]{step, g + j});
                    col.offer(new int[]{step, g + i});
                }
            }
        }
        return -1;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
