package leetcode.editor.cn;

import java.util.*;

/**
 * 猜数字大小 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-12 14:59:31
 */
public class GuessNumberHigherOrLowerIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            dp[i][i + 1] = i;
        }
        for (int i = n - 2; i >= 1; i--) {
            for (int j = i + 2; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + j;
                for (int k = i + 1; k <= j - 1; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][k - 1] + k, k + dp[k + 1][j]));
                }
                dp[i][j] = Math.min(dp[i][j], i + dp[i + 1][j]);
            }
        }
        return dp[1][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
