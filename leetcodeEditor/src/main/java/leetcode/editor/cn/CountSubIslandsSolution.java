package leetcode.editor.cn;

import java.util.*;

/**
 * 统计子岛屿
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-22 16:34:40
 */
public class CountSubIslandsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m, n;
    int[][] grid2;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        this.grid2 = grid2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 1表示g1中没有的格子，2表示g1也有的格子
                if (grid2[i][j] == 1) grid2[i][j] += grid1[i][j];
            }
        }
        int cnt = 0;
        // 找出只包含2的岛屿数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 2) {
                    if (dfs(i, j)) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    boolean dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return true;
        }
        if (grid2[i][j] != 2) {
            return grid2[i][j] == 0;
        }
        grid2[i][j] = 0;
        // 若与源点不是一个连通分量则不是子岛屿
        // 若在grid1中是海洋则不是子岛屿
        boolean d = dfs(i, j + 1);
        boolean u = dfs(i, j - 1);
        boolean r = dfs(i + 1, j);
        boolean l = dfs(i - 1, j);
        return d && u && r && l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
