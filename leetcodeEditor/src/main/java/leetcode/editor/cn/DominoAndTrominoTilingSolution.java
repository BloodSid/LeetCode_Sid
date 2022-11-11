package leetcode.editor.cn;
//有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。 
//
// 
//
// 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 10⁹ + 7 取模 的值。 
//
// 平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: n = 3
//输出: 5
//解释: 五种不同的方法如上所示。
// 
//
// 示例 2: 
//
// 
//输入: n = 1
//输出: 1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
// 👍 135 👎 0


/**
 * 多米诺和托米诺平铺
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-11-12 00:34:26 
 */
public class DominoAndTrominoTilingSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int HALF = 0;
    public static final int FULL = 1;
    public static final int MOD = (int) (1e9 + 7);

    public int numTilings(int n) {
        if (n == 1) return 1;
        // dp(s,i) 表示位置 i 处状态为 s, 且位置 i 之前瓷砖全铺满
        long[][] dp = new long[3][n];
        // 多米诺竖放
        dp[FULL][0] = 1;
        // 两种托米诺的放法
        dp[HALF][1] = 2;
        // 两块多米诺横放或竖放
        dp[FULL][1] = 2;
        for (int i = 2; i < n; i++) {
            // 托米诺的 + 多米诺的放法
            dp[HALF][i] = (2 * dp[FULL][i - 2] + dp[HALF][i - 1]) % MOD;
            // 两种托米诺的放法 + 一块多米诺的竖放方法 + 两块多米诺的横放
            dp[FULL][i] = (dp[HALF][i - 1] + dp[FULL][i - 1] + dp[FULL][i - 2]) % MOD;
        }
        return (int) dp[FULL][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
