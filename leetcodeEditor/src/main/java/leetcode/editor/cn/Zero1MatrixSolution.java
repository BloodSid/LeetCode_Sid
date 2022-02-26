package leetcode.editor.cn;

import java.util.*;

/**
 * 01 矩阵
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-27 00:02:29
 */
public class Zero1MatrixSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dis = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x < m && x >= 0 && y < n && y >= 0 && mat[x][y] == 1) {
                        mat[x][y] = 0;
                        dis[x][y] = depth;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            depth++;
        }
        return dis;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
