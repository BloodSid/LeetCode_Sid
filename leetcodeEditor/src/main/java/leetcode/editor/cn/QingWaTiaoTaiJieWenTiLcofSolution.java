package leetcode.editor.cn;

import java.util.*;

/**
 * 青蛙跳台阶问题
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-03 16:23:26
 */
public class QingWaTiaoTaiJieWenTiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
