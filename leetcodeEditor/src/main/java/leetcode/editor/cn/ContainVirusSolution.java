package leetcode.editor.cn;
//病毒扩散得很快，现在你的任务是尽可能地通过安装防火墙来隔离病毒。 
//
// 假设世界由 m x n 的二维矩阵 isInfected 组成， isInfected[i][j] == 0 表示该区域未感染病毒，而 
//isInfected[i][j] == 1 表示该区域已感染病毒。可以在任意 2 个相邻单元之间的共享边界上安装一个防火墙（并且只有一个防火墙）。 
//
// 每天晚上，病毒会从被感染区域向相邻未感染区域扩散，除非被防火墙隔离。现由于资源有限，每天你只能安装一系列防火墙来隔离其中一个被病毒感染的区域（一个区域或连
//续的一片区域），且该感染区域对未感染区域的威胁最大且 保证唯一 。 
//
// 你需要努力使得最后有部分区域不被病毒感染，如果可以成功，那么返回需要使用的防火墙个数; 如果无法实现，则返回在世界被病毒全部感染时已安装的防火墙个数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: isInfected = [[0,1,0,0,0,0,0,1],[0,1,0,0,0,0,0,1],[0,0,0,0,0,0,0,1],[0,0,0
//,0,0,0,0,0]]
//输出: 10
//解释:一共有两块被病毒感染的区域。
//在第一天，添加 5 墙隔离病毒区域的左侧。病毒传播后的状态是:
//
//第二天，在右侧添加 5 个墙来隔离病毒区域。此时病毒已经被完全控制住了。
//
// 
//
// 示例 2： 
//
// 
//
// 
//输入: isInfected = [[1,1,1],[1,0,1],[1,1,1]]
//输出: 4
//解释: 虽然只保存了一个小区域，但却有四面墙。
//注意，防火墙只建立在两个不同区域的共享边界上。
// 
//
// 示例 3: 
//
// 
//输入: isInfected = [[1,1,1,0,0,0,0,0,0],[1,0,1,0,1,1,1,1,1],[1,1,1,0,0,0,0,0,0]]
//
//输出: 13
//解释: 在隔离右边感染区域后，隔离左边病毒区域只需要 2 个防火墙。
// 
//
// 
//
// 提示: 
//
// 
// m == isInfected.length 
// n == isInfected[i].length 
// 1 <= m, n <= 50 
// isInfected[i][j] is either 0 or 1 
// 在整个描述的过程中，总有一个相邻的病毒区域，它将在下一轮 严格地感染更多未受污染的方块 
// 
//
// 
// 👍 88 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 隔离病毒
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-07-18 14:34:13 
 */
public class ContainVirusSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static final int UNINFECTED = 0;
    public static final int INFECTED = 1;
    public static final int BLOCKED = 2;
    private int[][] g;
    private int m;
    private int n;

    public int containVirus(int[][] isInfected) {
        g = isInfected;
        m = g.length;
        n = g[0].length;
        int sum = 0;
        while (true) {
            int walls = install();
            if (walls == 0) break;
            sum += walls;
        }
        return sum;
    }

    // 返回安装数
    int install() {
        int walls = 0;
        // 记录最大的将要感染值
        int max = 0;
        List<int[]> toBlock = null, toBlockNext = null;
        List<List<int[]>> toInfect = new ArrayList<>();
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == INFECTED && !vis[i][j]) {
                    ArrayList<int[]> origin = new ArrayList<>();
                    ArrayList<int[]> next = new ArrayList<>();
                    int w = bfs(i, j, vis, origin, next);
                    toInfect.add(next);
                    if (next.size() > max) {
                        walls = w;
                        max = next.size();
                        toBlock = origin;
                        toBlockNext = next;
                    }
                }
            }
        }
        // 没有找到将要感染的格子
        if (max == 0) return 0;
        for (int[] p : toBlock) {
            g[p[0]][p[1]] = BLOCKED;
        }
        for (List<int[]> list : toInfect) {
            // 把没隔离的格子感染
            if (list != toBlockNext) {
                for (int[] p : list) {
                    g[p[0]][p[1]] = INFECTED;
                }
            }
        }
        return walls;
    }

    // 广度优先搜索，返回安装数。origin记录已经感染，next记录将要感染
    int bfs(int x, int y, boolean[][]vis, List<int[]> origin, List<int[]> next) {
        int walls = 0;
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        vis[x][y] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            origin.add(cur);
            for (int[] dir : DIRS) {
                int nx = dir[0] + cur[0];
                int ny = dir[1] + cur[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (g[nx][ny] == UNINFECTED) {
                    walls++;
                }
                if (!vis[nx][ny]) {
                    vis[nx][ny] = true;
                    // 未感染
                    if (g[nx][ny] == UNINFECTED) {
                        next.add(new int[]{nx, ny});
                        // 已感染
                    } else if (g[nx][ny] == INFECTED) {
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return walls;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
