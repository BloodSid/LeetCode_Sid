package leetcode.editor.cn;
//「推箱子」是一款风靡全球的益智小游戏，玩家需要将箱子推到仓库中的目标位置。 
//
// 游戏地图用大小为 m x n 的网格 grid 表示，其中每个元素可以是墙、地板或者是箱子。 
//
// 现在你将作为玩家参与游戏，按规则将箱子 'B' 移动到目标位置 'T' ： 
//
// 
// 玩家用字符 'S' 表示，只要他在地板上，就可以在网格中向上、下、左、右四个方向移动。 
// 地板用字符 '.' 表示，意味着可以自由行走。 
// 墙用字符 '#' 表示，意味着障碍物，不能通行。 
// 箱子仅有一个，用字符 'B' 表示。相应地，网格上有一个目标位置 'T'。 
// 玩家需要站在箱子旁边，然后沿着箱子的方向进行移动，此时箱子会被移动到相邻的地板单元格。记作一次「推动」。 
// 玩家无法越过箱子。 
// 
//
// 返回将箱子推到目标位置的最小 推动 次数，如果无法做到，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [["#","#","#","#","#","#"],
//             ["#","T","#","#","#","#"],
//             ["#",".",".","B",".","#"],
//             ["#",".","#","#",".","#"],
//             ["#",".",".",".","S","#"],
//             ["#","#","#","#","#","#"]]
//输出：3
//解释：我们只需要返回推箱子的次数。 
//
// 示例 2： 
//
// 
//输入：grid = [["#","#","#","#","#","#"],
//             ["#","T","#","#","#","#"],
//             ["#",".",".","B",".","#"],
//             ["#","#","#","#",".","#"],
//             ["#",".",".",".","S","#"],
//             ["#","#","#","#","#","#"]]
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：grid = [["#","#","#","#","#","#"],
//             ["#","T",".",".","#","#"],
//             ["#",".","#","B",".","#"],
//             ["#",".",".",".",".","#"],
//             ["#",".",".",".","S","#"],
//             ["#","#","#","#","#","#"]]
//输出：5
//解释：向下、向左、向左、向上再向上。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 20 
// grid 仅包含字符 '.', '#', 'S' , 'T', 以及 'B'。 
// grid 中 'S', 'B' 和 'T' 各只能出现一个。 
// 
//
// 👍 195 👎 0


import java.util.*;

/**
 * 推箱子
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-29 20:38:03 
 */
public class MinimumMovesToMoveABoxToTheirTargetLocationSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int minPushBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int sx = 0, sy = 0, tx = 0, ty = 0, bx = 0, by = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'T') {
                    tx = i; ty = j;
                } else if (grid[i][j] == 'S') {
                    sx = i; sy = j;
                } else if (grid[i][j] == 'B') {
                    bx = i; by = j;
                }
            }
        }
        boolean[][][][] vis = new boolean[m][n][m][n];
        vis[sx][sy][bx][by] = true;
        // x,y 玩家的位置，a,b 箱子的位置, d 推动的次数
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, bx, by, 0});
        while (!q.isEmpty()) {
            int[] p = q.pollFirst();
            int x = p[0], y = p[1], a = p[2], b = p[3], d = p[4];
            if (a == tx && b == ty) return d;
            for (int[] dir : DIRS) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= m || nx < 0 || ny >= n || ny < 0) continue;
                // 判断是不是箱子，箱子后面不是墙就可移动
                if (nx == a && ny == b) {
                    int na = a + dir[0], nb = b + dir[1];
                    if (na >= m || na < 0 || nb >= n || nb < 0) continue;
                    if (grid[na][nb] == '#') continue;
                    if (vis[nx][ny][na][nb]) continue;
                    vis[nx][ny][na][nb] = true;
                    q.offerLast(new int[]{nx, ny, na, nb, d + 1});
                } else if (grid[nx][ny] != '#') {
                    // 不是墙就可以移动
                    if (vis[nx][ny][a][b]) continue;
                    vis[nx][ny][a][b] = true;
                    q.offerFirst(new int[]{nx, ny, a, b, d});
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
