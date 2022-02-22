package leetcode.editor.cn;

import java.util.*;

/**
 * 统计封闭岛屿的数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-22 11:15:36
 */
public class NumberOfClosedIslandsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[][] grid;
    private int m;
    private int n;

    public int closedIsland(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for (int i = 0; i < m; i++) {
            dfs(i, 0);
            dfs(i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j);
            dfs(m - 1, j);
        }
        int cnt = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        return cnt;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1;
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
