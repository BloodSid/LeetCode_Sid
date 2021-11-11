package leetcode.editor.cn;

import java.util.*;

/**
 * K个逆序对数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-11 14:44:13
 */
public class KInversePairsArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        // dp[i][j] 代表由[1,i]的数所能构成的逆序对数量为j的数组个数
        int[][] dp = new int[n + 1][k + 1];
        dp[1][0] = 1;
        int[] sum = new int[k + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                sum[j] = j == 0 ? dp[i - 1][0] : (sum[j - 1] + dp[i - 1][j]) % mod;
                dp[i][j] = i > j ? sum[j] : (sum[j] - sum[j - (i - 1) - 1] + mod) % mod;
            }
        }
        return dp[n][k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
