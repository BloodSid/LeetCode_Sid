package leetcode.editor.cn;

import java.util.*;

/**
 * 接雨水 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-03 12:17:13
 */
public class TrappingRainWaterIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        if (m < 3 || n < 3) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            visited[i][0] = true;
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            visited[0][j] = true;
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[m - 1][j] = true;
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) {
                    continue;
                }
                int h = heightMap[x][y];
                if (h < cur[2]) {
                    sum += cur[2] - h;
                    h = cur[2];
                }
                pq.offer(new int[]{x, y, h});
                visited[x][y] = true;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
