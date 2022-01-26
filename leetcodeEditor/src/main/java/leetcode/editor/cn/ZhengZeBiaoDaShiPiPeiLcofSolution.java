package leetcode.editor.cn;

import java.util.*;

/**
 * 正则表达式匹配
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-24 16:57:38
 */
public class ZhengZeBiaoDaShiPiPeiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String str, String pattern) {
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();
        int m = s.length, n = p.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p[j - 1] == '*') {
                    dp[i][j] = i > 0 && (p[j - 2] == '.' || s[i - 1] == p[j - 2]) ?
                            (dp[i - 1][j] || dp[i][j - 2]) : dp[i][j - 2];
                } else {
                    dp[i][j] = (i > 0 && (p[j - 1] == '.' || s[i - 1] == p[j - 1])) && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
