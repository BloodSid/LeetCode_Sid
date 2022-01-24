package leetcode.editor.cn;

import java.util.*;

/**
 * 丑数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-24 12:40:59 
 */
public class ChouShuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        //数组dp的k个指针，和primes对应
        int[] primes = {2, 3, 5};
        int[] indexes = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int min = dp[indexes[0]] * primes[0];
            for (int j = 1; j < primes.length; j++) {
                min = Math.min(min, dp[indexes[j]] * primes[j]);
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (dp[i] == dp[indexes[j]] * primes[j]) {
                    indexes[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
