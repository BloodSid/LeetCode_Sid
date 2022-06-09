package leetcode.editor.cn;
//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
// 👍 1396 👎 0


/**
 * 完全平方数
 *
 * @author IronSid
 * @since 2022-06-09 23:57:57 
 * @version 1.0
 */
public class PerfectSquaresSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        int m = (int) Math.sqrt(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int sq = i * i;
            for (int j = 0; j <= n - sq; j++) {
                dp[j + sq] = dp[j + sq] == 0 ? dp[j] + 1 :Math.min(dp[j + sq], dp[j] + 1);
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
