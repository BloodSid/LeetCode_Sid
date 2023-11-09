package leetcode.editor.cn;
//给你两个整数 m 和 n 表示一个下标从 0 开始的 m x n 网格图。同时给你两个二维整数数组 guards 和 walls ，其中 guards[i]
// = [rowi, coli] 且 walls[j] = [rowj, colj] ，分别表示第 i 个警卫和第 j 座墙所在的位置。 
//
// 一个警卫能看到 4 个坐标轴方向（即东、南、西、北）的 所有 格子，除非他们被一座墙或者另外一个警卫 挡住 了视线。如果一个格子能被 至少 一个警卫看到，
//那么我们说这个格子被 保卫 了。 
//
// 请你返回空格子中，有多少个格子是 没被保卫 的。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
//输出：7
//解释：上图中，被保卫和没有被保卫的格子分别用红色和绿色表示。
//总共有 7 个没有被保卫的格子，所以我们返回 7 。
// 
//
// 示例 2： 
//
// 
//
// 输入：m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
//输出：4
//解释：上图中，没有被保卫的格子用绿色表示。
//总共有 4 个没有被保卫的格子，所以我们返回 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 10⁵ 
// 2 <= m * n <= 10⁵ 
// 1 <= guards.length, walls.length <= 5 * 10⁴ 
// 2 <= guards.length + walls.length <= m * n 
// guards[i].length == walls[j].length == 2 
// 0 <= rowi, rowj < m 
// 0 <= coli, colj < n 
// guards 和 walls 中所有位置 互不相同 。 
// 
//
// 👍 20 👎 0


/**
 * 统计网格图中没有被保卫的格子数
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-11-09 15:25:27 
 */
public class CountUnguardedCellsInTheGridSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] g = new int[m][n];
        // 警卫
        for (int[] p : guards) g[p[0]][p[1]] = -1;
        // 墙
        for (int[] p : walls) g[p[0]][p[1]] = -2;
        for (int i = 0; i < m; i++) {
            int last = 0;
            for (int j = 0; j < n; j++) {
                if (g[i][j] < 0) last = g[i][j];
                else if (last == -1) g[i][j]++;
            }
            last = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (g[i][j] < 0) last = g[i][j];
                else if (last == -1) g[i][j]++;
            }
        }
        for (int j = 0; j < n; j++) {
            int last = 0;
            for (int i = 0; i < m; i++) {
                if (g[i][j] < 0) last = g[i][j];
                else if (last == -1) g[i][j]++;
            }
            last = 0;
            for (int i = m - 1; i >= 0; i--) {
                if (g[i][j] < 0) last = g[i][j];
                else if (last == -1) g[i][j]++;
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (g[i][j] == 0) cnt++;
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
