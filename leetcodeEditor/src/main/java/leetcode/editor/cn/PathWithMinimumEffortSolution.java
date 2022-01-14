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
    // 0 表示未访问，1表示起点，2表示终点
    boolean[][] visited;
    int[][] diff;

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int INFINITE = 1_000_001;
        visited = new boolean[m][n];
        diff = new int[m][n];
        for (int[] ints : diff) {
            Arrays.fill(ints, INFINITE);
        }
        // pq中的数组为{x, y}, x y表示坐标
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> diff[o1[0]][o1[1]] - diff[o2[0]][o2[1]]);
        pq.offer(new int[]{0, 0});
        diff[0][0] = 0;
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            visited[cur[0]][cur[1]] = true;
            res = Math.max(diff[cur[0]][cur[1]], res);
            if (cur[0] == m - 1 && cur[1] == n - 1) {
                break;
            }
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    int h = Math.abs(heights[x][y] - heights[cur[0]][cur[1]]);
                    diff[x][y] = Math.min(h, diff[x][y]);
                    pq.offer(new int[]{x, y});
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
