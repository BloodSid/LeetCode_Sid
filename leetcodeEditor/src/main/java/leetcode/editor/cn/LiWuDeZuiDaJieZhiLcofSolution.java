package leetcode.editor.cn;

import java.util.*;

/**
 * 礼物的最大价值
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-04 16:46:10
 */
public class LiWuDeZuiDaJieZhiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = j > 0 ? dp[i][j - 1] : 0;
                int up = i > 0 ? dp[i - 1][j] : 0;
                dp[i][j] = grid[i][j] + Math.max(left, up);
            }
        }
        return dp[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
