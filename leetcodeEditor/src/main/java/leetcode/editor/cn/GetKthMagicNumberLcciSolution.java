package leetcode.editor.cn;
//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// 👍 100 👎 0


/**
 * 第 k 个数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-09-28 00:51:28 
 */
public class GetKthMagicNumberLcciSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        int p3 = 0, p5 = 0, p7 = 0;
        for (int i = 1; i < k; i++) {
            dp[i] = (int) Math.min(Math.min(dp[p3] * 3L, dp[p5] * 5L), dp[p7] * 7L);
            if(dp[i] == dp[p3] * 3L) p3++;
            if(dp[i] == dp[p5] * 5L) p5++;
            if(dp[i] == dp[p7] * 7L) p7++;
        }
        return dp[k - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
