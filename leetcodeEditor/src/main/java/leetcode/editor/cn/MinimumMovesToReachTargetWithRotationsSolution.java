package leetcode.editor.cn;
//你还记得那条风靡全球的贪吃蛇吗？ 
//
// 我们在一个 n*n 的网格上构建了新的迷宫地图，蛇的长度为 2，也就是说它会占去两个单元格。蛇会从左上角（(0, 0) 和 (0, 1)）开始移动。我们用
// 0 表示空单元格，用 1 表示障碍物。蛇需要移动到迷宫的右下角（(n-1, n-2) 和 (n-1, n-1)）。 
//
// 每次移动，蛇可以这样走： 
//
// 
// 如果没有障碍，则向右移动一个单元格。并仍然保持身体的水平／竖直状态。 
// 如果没有障碍，则向下移动一个单元格。并仍然保持身体的水平／竖直状态。 
// 如果它处于水平状态并且其下面的两个单元都是空的，就顺时针旋转 90 度。蛇从（(r, c)、(r, c+1)）移动到 （(r, c)、(r+1, c)）。
// 
// 
// 如果它处于竖直状态并且其右面的两个单元都是空的，就逆时针旋转 90 度。蛇从（(r, c)、(r+1, c)）移动到（(r, c)、(r, c+1)）。 
//
// 
// 
//
// 返回蛇抵达目的地所需的最少移动次数。 
//
// 如果无法到达目的地，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[0,0,0,0,0,1],
//               [1,1,0,0,1,0],
//               [0,0,0,0,1,1],
//               [0,0,1,0,1,0],
//               [0,1,1,0,0,0],
//               [0,1,1,0,0,0]]
//输出：11
//解释：
//一种可能的解决方案是 [右, 右, 顺时针旋转, 右, 下, 下, 下, 下, 逆时针旋转, 右, 下]。
// 
//
// 示例 2： 
//
// 输入：grid = [[0,0,1,1,1,1],
//               [0,0,0,0,1,1],
//               [1,1,0,0,0,1],
//               [1,1,1,0,0,1],
//               [1,1,1,0,0,1],
//               [1,1,1,0,0,0]]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 100 
// 0 <= grid[i][j] <= 1 
// 蛇保证从空单元格开始出发。 
// 
// 👍 118 👎 0


import java.util.*;

/**
 * 穿过迷宫的最少移动次数
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-02-05 23:38:24 
 */
public class MinimumMovesToReachTargetWithRotationsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int HORI = 0;
    public static final int VERT = 1;

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        boolean[][][] vis = new boolean[n][n][2];
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, HORI});
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int x = poll[0], y = poll[1], dir = poll[2];
                if (x == n - 1 && y == n - 2 && dir == HORI) return depth;
                // 竖直状态，向下
                if (x + 2 < n && grid[x + 2][y] == 0 && dir == VERT && !vis[x + 1][y][VERT]) {
                    q.offer(new int[]{x + 1, y, VERT});
                    vis[x + 1][y][VERT] = true;
                }
                // 水平状态，向右
                if (y + 2 < n && grid[x][y + 2] == 0 && dir == HORI && !vis[x][y + 1][HORI]) {
                    q.offer(new int[]{x, y + 1, HORI});
                    vis[x][y + 1][HORI] = true;
                }
                // 下面两格是空的，且水平，向下，或者顺时针转
                if (x + 1 < n && y + 1 < n && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0 && dir == HORI) {
                    if (!vis[x + 1][y][HORI]) {
                        q.offer(new int[]{x + 1, y, HORI});
                        vis[x + 1][y][HORI] = true;
                    }
                    if (!vis[x][y][VERT]) {
                        q.offer(new int[]{x, y, VERT});
                        vis[x][y][VERT] = true;
                    }
                }
                // 右面两格是空的，且竖直，向右，或者逆时针转
                if (x + 1 < n && y + 1 < n && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0 && dir == VERT) {
                    if (!vis[x][y + 1][VERT]) {
                        q.offer(new int[]{x, y + 1, VERT});
                        vis[x][y + 1][VERT] = true;
                    }
                    if (!vis[x][y][HORI]) {
                        q.offer(new int[]{x, y, HORI});
                        vis[x][y][HORI] = true;
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
