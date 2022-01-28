package leetcode.editor.cn;

import java.util.*;

/**
 * 地图中的最高点
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-29 00:15:12
 */
public class MapOfHighestPeakSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] highestPeak(int[][] isWater) {
        Deque<int[]> queue = new LinkedList<>();
        int m = isWater.length;
        int n = isWater[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] res = new int[m][n];
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];
                res[x][y] = height;
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && isWater[nx][ny] == 0) {
                        queue.offer(new int[]{nx, ny});
                        isWater[nx][ny] = 1;
                    }
                }
            }
            height++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
