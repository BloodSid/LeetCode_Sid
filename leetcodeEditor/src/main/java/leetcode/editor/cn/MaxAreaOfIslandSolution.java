package leetcode.editor.cn;

import java.util.*;

/**
 * 岛屿的最大面积
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-21 22:20:09
 */
public class MaxAreaOfIslandSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[][] grid;
    private int m;
    private int n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }
        return max;
    }

    private int dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        int area = 1;
        grid[i][j] = 0;
        area += dfs(i + 1, j);
        area += dfs(i - 1, j);
        area += dfs(i, j + 1);
        area += dfs(i, j - 1);
        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
