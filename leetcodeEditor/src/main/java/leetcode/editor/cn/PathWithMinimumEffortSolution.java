package leetcode.editor.cn;

import java.util.*;

/**
 * 最小体力消耗路径
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-13 23:06:29
 */
public class PathWithMinimumEffortSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] visited;
    int[][] heights;
    int m, n;

    public int minimumEffortPath(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        int l = 0, r = 1_000_000;
        while (l <= r) {
            int mid = (l + r) >> 1;
            visited = new boolean[m][n];
            if (dfs(0, 0, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    boolean dfs(int x, int y, int diff) {
        if (x == m - 1 && y == n - 1) {
            return true;
        }
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]
                    && Math.abs(heights[x][y] - heights[nx][ny]) <= diff) {
                if (dfs(nx, ny, diff)) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
