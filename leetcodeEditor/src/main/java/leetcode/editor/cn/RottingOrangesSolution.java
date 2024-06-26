package leetcode.editor.cn;
//在给定的网格中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。 
//
// 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 输入：[[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 输入：[[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 10 
// 1 <= grid[0].length <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// Related Topics 广度优先搜索 数组 矩阵 
// 👍 411 👎 0


import java.util.*;

/**
 * 腐烂的橘子
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-09-04 23:48:36
 */
public class RottingOrangesSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int days = 0;
        while (true) {
            for (int len = q.size(); len > 0; len--) {
                int[] p = q.poll();
                int x = p[0], y = p[1];
                for (int[] d : DIRS) {
                    int nx = d[0] + x, ny = d[1] + y;
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                        continue;
                    }
                    if (grid[nx][ny] != 1) continue;
                    grid[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                    fresh--;
                }
            }
            if (q.isEmpty()) break;
            days++;
        }
        if (fresh != 0) return -1;
        return days;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
