package leetcode.editor.cn;
//给你一个下标从 0 开始大小为 m x n 的二维整数数组 grid ，它表示一个网格图。每个格子为下面 3 个值之一： 
//
// 
// 0 表示草地。 
// 1 表示着火的格子。 
// 2 表示一座墙，你跟火都不能通过这个格子。 
// 
//
// 一开始你在最左上角的格子 (0, 0) ，你想要到达最右下角的安全屋格子 (m - 1, n - 1) 。每一分钟，你可以移动到 相邻 的草地格子。每次你
//移动 之后 ，着火的格子会扩散到所有不是墙的 相邻 格子。 
//
// 请你返回你在初始位置可以停留的 最多 分钟数，且停留完这段时间后你还能安全到达安全屋。如果无法实现，请你返回 -1 。如果不管你在初始位置停留多久，你 总
//是 能到达安全屋，请你返回 10⁹ 。 
//
// 注意，如果你到达安全屋后，火马上到了安全屋，这视为你能够安全到达安全屋。 
//
// 如果两个格子有共同边，那么它们为 相邻 格子。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0
//,0,0,0,0,0,0]]
//输出：3
//解释：上图展示了你在初始位置停留 3 分钟后的情形。
//你仍然可以安全到达安全屋。
//停留超过 3 分钟会让你无法安全到达安全屋。 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
//输出：-1
//解释：上图展示了你马上开始朝安全屋移动的情形。
//火会蔓延到你可以移动的所有格子，所以无法安全到达安全屋。
//所以返回 -1 。
// 
//
// 示例 3： 
//
// 
//
// 输入：grid = [[0,0,0],[2,2,0],[1,2,0]]
//输出：1000000000
//解释：上图展示了初始网格图。
//注意，由于火被墙围了起来，所以无论如何你都能安全到达安全屋。
//所以返回 10⁹ 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 2 <= m, n <= 300 
// 4 <= m * n <= 2 * 10⁴ 
// grid[i][j] 是 0 ，1 或者 2 。 
// grid[0][0] == grid[m - 1][n - 1] == 0 
// 
//
// 👍 70 👎 0


import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 逃离火灾
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-11-09 10:08:52 
 */
public class EscapeTheSpreadingFireSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static final int INF = (int) (1e9 + 7);
    private int m;
    private int n;

    public int maximumMinutes(int[][] grid) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        m = grid.length;
        n = grid[0].length;
        // g[x][y] 0 表示一开始着火，正数表示着火时间，-2 表示墙, INF 表示空地
        int[][] g = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    g[i][j] = 0;
                }
                else if (grid[i][j] == 2) g[i][j] = -2;
                else if (grid[i][j] == 0) g[i][j] = INF;
            }
        }
        // 预处理时间-燃烧点图
        int time = 1;
        for (; !q.isEmpty(); time++) {
            for (int sz = q.size(); sz > 0; sz--) {
                int[] p = q.poll();
                int x = p[0], y = p[1];
                for (int[] dir : DIRS) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                    if (g[nx][ny] == INF) {
                        g[nx][ny] = time;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        for (int i = 0; i < g.length; i++) {
            System.out.println(Arrays.toString(g[i]));
        }
        int l = 0, r = time;
        // 二分停留时间，然后进行bfs
        while (l <= r) {
            int mid = l + r >> 1;
            q = new ArrayDeque<>();
            q.offer(new int[]{0, 0});
            boolean[][] vis = new boolean[m][n];
            boolean safe = false;
            loop:
            for (int t = mid + 1; !q.isEmpty(); t++)
                for (int sz = q.size(); sz > 0; sz--) {
                    int[] p = q.poll();
                    int x = p[0], y = p[1];
                    // 判断下一时刻周围有哪些格子可走
                    for (int[] dir : DIRS) {
                        int nx = x + dir[0], ny = y + dir[1];
                        if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                        if (vis[nx][ny]) continue;
                        // 到达安全屋后，火马上到了安全屋，视为能够安全到达安全屋。虽然下一时刻安全屋可以着火，但是当前必须不能着火
                        if (nx == m - 1 && ny == n - 1 && g[nx][ny] >= t) {
                            safe = true;
                            break loop;
                        }
                        // 下一时刻不着火的格子可走
                        if (g[nx][ny] > t) {
                            vis[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            if (safe) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r < time ? r : (int) 1e9;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
