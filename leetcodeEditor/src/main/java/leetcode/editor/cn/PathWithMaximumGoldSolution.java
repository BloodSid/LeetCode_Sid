package leetcode.editor.cn;

import java.util.*;

/**
 * 黄金矿工
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-05 00:07:12
 */
public class PathWithMaximumGoldSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m, n;

    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, getMax(i, j, grid));
                }
            }
        }
        return max;
    }

    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    int getMax(int i, int j, int[][] grid) {
        int curGold = grid[i][j];
        grid[i][j] = 0;
        int max = 0;
        for (int[] direction : directions) {
            int ni = i + direction[0];
            int nj = j + direction[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] != 0) {
                max = Math.max(max, getMax(ni, nj, grid));
            }
        }
        grid[i][j] = curGold;
        return max + curGold;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
