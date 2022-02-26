package leetcode.editor.cn;

import java.util.*;

/**
 * 二进制矩阵中的最短路径
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-26 23:48:38
 */
public class ShortestPathInBinaryMatrixSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer((0 << 8) + 0);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                int x = cur >> 8;
                int y = cur & 255;
                if (x == m - 1 && y == n - 1) {
                    return depth;
                }
                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < m && nx >= 0 && ny < n && ny >= 0 && grid[nx][ny] == 0) {
                        grid[nx][ny] = 1;
                        queue.offer((nx << 8) + ny);
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
