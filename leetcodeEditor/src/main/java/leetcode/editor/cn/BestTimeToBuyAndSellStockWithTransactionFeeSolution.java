package leetcode.editor.cn;
//给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。 
//
// 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。 
//
// 返回获得利润的最大值。 
//
// 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。 
//
// 
//
// 示例 1： 
//
// 
//输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
//输出：8
//解释：能够达到的最大利润:  
//在此处买入 prices[0] = 1
//在此处卖出 prices[3] = 8
//在此处买入 prices[4] = 4
//在此处卖出 prices[5] = 9
//总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8 
//
// 示例 2： 
//
// 
//输入：prices = [1,3,7,5,10,3], fee = 3
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5 * 10⁴ 
// 1 <= prices[i] < 5 * 10⁴ 
// 0 <= fee < 5 * 10⁴ 
// 
// 👍 725 👎 0


/**
 * 买卖股票的最佳时机含手续费
 *
 * @author IronSid
 * @since 2022-06-09 22:33:59 
 * @version 1.0
 */
public class BestTimeToBuyAndSellStockWithTransactionFeeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final int EMPTY = 0;
    private static final int HOLDING = 1;

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[2][n];
        dp[HOLDING][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[EMPTY][i] = Math.max(dp[EMPTY][i - 1], dp[HOLDING][i - 1] + prices[i] - fee);
            dp[HOLDING][i] = Math.max(dp[HOLDING][i - 1], dp[EMPTY][i - 1] - prices[i]);
        }
        return dp[EMPTY][n - 1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
