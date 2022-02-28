package leetcode.editor.cn;

import java.util.*;

/**
 * 最短的桥
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-01 02:02:04
 */
public class ShortestBridgeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Queue<int[]> queue = new ArrayDeque<>();
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int m;
    private int n;
    int[][] grid;

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int x = 0, y = 0;
        loop:
        for (; x < m; x++) {
            for (y = 0; y < n; y++) {
                if (grid[x][y] == 1) break loop;
            }
        }
        dfs(x, y);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int nx = cur[0] + dir[0], ny = cur[1] + dir[1];
                    if (nx < m && nx >= 0 && ny < n && ny >= 0 && grid[nx][ny] != 2) {
                        // 搜索到另外一个岛的陆地
                        if (grid[nx][ny] == 1) return depth;
                        // 搜索到海洋
                        // 不标记搜索过的海洋就会内存溢出
                        grid[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            depth++;
        }
        return -1;
    }

    // dfs 搜索相连接的陆地，全部标记为2,并把这些格子都入队
    void dfs(int i, int j) {
        grid[i][j] = 2;
        queue.offer(new int[]{i, j});
        for (int[] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni < m && ni >= 0 && nj < n && nj >= 0 && grid[ni][nj] == 1) {
                dfs(ni, nj);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
