package leetcode.editor.cn;

import java.util.*;

/**
 * 剪绳子 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-19 13:46:33
 */
public class JianShengZiIiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int N = 1000;
    int[] dp = new int[N + 1];
    int MOD = 1_000_000_007;

    {
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        for (int i = 7; i <= N; i++) {
            dp[i] = (int) (dp[i - 3] * 3L % MOD);
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
