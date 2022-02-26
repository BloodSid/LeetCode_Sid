package leetcode.editor.cn;

import java.util.*;

/**
 * 太平洋大西洋水流问题
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-26 23:14:33
 */
public class PacificAtlanticWaterFlowSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] visited = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        // 广度优先搜索可以到达上右的格子
        for (int i = 0; i < m; i++) {
            visited[i][0] |= 1;
            queue.offer(new int[]{i, 0});
        }
        for (int i = 1; i < n; i++) {
            visited[0][i] |= 1;
            queue.offer(new int[]{0, i});
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && (visited[x][y] & 1) == 0
                        && heights[x][y] >= heights[cur[0]][cur[1]]) {
                    visited[x][y] |= 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        // 广度优先搜索可以到达下左的格子
        queue.clear();
        for (int i = 0; i < m; i++) {
            visited[i][n - 1] |= 2;
            queue.offer(new int[]{i, n - 1});
        }
        for (int i = 0; i < n - 1; i++) {
            visited[m - 1][i] |= 2;
            queue.offer(new int[]{m - 1, i});
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && (visited[x][y] & 2) == 0
                        && heights[x][y] >= heights[cur[0]][cur[1]]) {
                    visited[x][y] |= 2;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        // 取出结果
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 3) {
                    List<Integer> cur = new LinkedList<>();
                    cur.add(i);
                    cur.add(j);
                    list.add(cur);
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
