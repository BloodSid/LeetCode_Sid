package leetcode.editor.cn;
//给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 100 
// 1 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
//
// 👍 1100 👎 0


import java.util.Arrays;

/**
 * 买卖股票的最佳时机 IV
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-10-30 14:54:25 
 */
public class BestTimeToBuyAndSellStockIvSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int INF = (int) (1e9 + 7);

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // dp(i,j,0) 表示第i天，至多交易j次且不持有股票的最大利润，d(i,j,1) 表示持有股票的最大利润
        // 在i，j的最前面插入-1虚状态方便计算。
        int[][][] dp = new int[n + 1][k + 2][2];
        // 初始化
        for (int i = 0; i <= n; i++) for (int j = 0; j <= k+1; j++) {
            Arrays.fill(dp[i][j], -INF);
        }
        // i < 0 且 k = 0 即开始前（-1天）且不持有的状态初始化为0
        for (int j = 1; j <= k + 1; j++) dp[0][j][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i + 1][j + 1][0] = Math.max(dp[i][j + 1][0], dp[i][j][1] + prices[i]);
                dp[i + 1][j + 1][1] = Math.max(dp[i][j + 1][1], dp[i][j + 1][0] - prices[i]);
            }
        }
        return dp[n][k+1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
