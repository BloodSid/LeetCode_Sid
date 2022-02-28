package leetcode.editor.cn;

import java.util.*;

/**
 * 迷宫中离入口最近的出口
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-01 02:31:56
 */
public class NearestExitFromEntranceInMazeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    final char EMPTY = '.';
    final char WALL = '+';
    char[][] maze;
    int m, n;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        this.maze = maze;
        m = maze.length;
        n = maze[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = WALL;
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                if ((x == 0 || x == m - 1 || y == 0 || y == n - 1) && (x != entrance[0] || y != entrance[1])) {
                    return depth;
                }
                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < m && nx >= 0 && ny < n && ny >= 0 && maze[nx][ny] == EMPTY) {
                        maze[nx][ny] = WALL;
                        queue.offer(new int[]{nx, ny});
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
