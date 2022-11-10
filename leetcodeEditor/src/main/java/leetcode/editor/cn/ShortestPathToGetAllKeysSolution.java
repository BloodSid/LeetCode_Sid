package leetcode.editor.cn;
//给定一个二维网格 grid ，其中： 
//
// 
// '.' 代表一个空房间 
// '#' 代表一堵 
// '@' 是起点 
// 小写字母代表钥匙 
// 大写字母代表锁 
// 
//
// 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们
//手里有对应的钥匙，否则无法通过锁。 
//
// 假设 k 为 钥匙/锁 的个数，且满足 1 <= k <= 6，字母表中的前 k 个字母在网格中都有自己对应的一个小写和一个大写字母。换言之，每个锁有唯一
//对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。 
//
// 返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = ["@.a.#","###.#","b.A.B"]
//输出：8
//解释：目标是获得所有钥匙，而不是打开所有锁。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = ["@..aA","..B#.","....b"]
//输出：6
// 
//
// 示例 3: 
//
// 
//输入: grid = ["@Aa"]
//输出: -1 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 30 
// grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F' 
// 钥匙的数目范围是 [1, 6] 
// 每个钥匙都对应一个 不同 的字母 
// 每个钥匙正好打开一个对应的锁 
// 
// 👍 215 👎 0


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 获取所有钥匙的最短路径
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-11-10 21:01:11 
 */
public class ShortestPathToGetAllKeysSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int shortestPathAllKeys(String[] grid) {
        char[][] g = new char[grid.length][];
        for (int i = 0; i < g.length; i++) {
            g[i] = grid[i].toCharArray();
        }
        int m = g.length;
        int n = g[0].length;
        int sx = 0, sy = 0;
        // 用 status 的二进制表示钥匙，0表示钥匙已获得，1表示钥匙未获得
        int originStatus = 0;
        // 记录起点和钥匙的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = g[i][j];
                if (c == '@') {
                    sx = i;
                    sy = j;
                } else if (c >= 'a' && c <= 'f') {
                    originStatus |= 1 << c - 'a';
                }
            }
        }
        // 广度优先遍历
        Deque<int[]> q = new ArrayDeque<>();
        // 初始状态
        q.offer(new int[]{sx, sy, originStatus});
        boolean[][][] vis = new boolean[m][n][1 << 6];
        vis[sx][sy][originStatus] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i1 = 0; i1 < size; i1++) {
                int[] poll = q.poll();
                int x = poll[0], y = poll[1], status = poll[2];
                // 所有钥匙全找到
                if (poll[2] == 0) return level;
                for (int[] dir : DIRS) {
                    int nx = x + dir[0], ny = y + dir[1];
                    int newStatus = status;
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    // 相邻点是墙则跳过
                    if (g[nx][ny] == '#') continue;
                    // 相邻点是锁且钥匙未获得则跳过
                    if (g[nx][ny] >= 'A' && g[nx][ny] <= 'F' && ((status >> g[nx][ny] - 'A') & 1) == 1) continue;
                    // 相邻点是钥匙, 则把对应二进制位置为零
                    if (g[nx][ny] >= 'a' && g[nx][ny] <= 'f') {
                        newStatus &= ~(1 << g[nx][ny] - 'a');
                    }
                    // 相邻点访问过
                    if (vis[nx][ny][newStatus]) continue;
                    q.offer(new int[]{nx, ny, newStatus});
                    vis[nx][ny][newStatus] = true;
                }
            }
            level++;
        }
        return -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
