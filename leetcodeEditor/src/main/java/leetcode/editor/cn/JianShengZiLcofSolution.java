package leetcode.editor.cn;

import java.util.*;

/**
 * 剪绳子
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-19 13:46:27
 */
public class JianShengZiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int N = 58;
    int[] dp = new int[N + 1];

    {
        for (int i = 0; i < 4; i++) {
            dp[i] = i;
        }
        for (int i = 4; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
        }
    }

    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
