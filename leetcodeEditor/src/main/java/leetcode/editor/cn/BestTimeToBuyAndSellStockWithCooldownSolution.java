package leetcode.editor.cn;
//给定一个整数数组 prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
// 👍 1231 👎 0


/**
 * 最佳买卖股票时机含冷冻期
 *
 * @author IronSid
 * @since 2022-06-09 22:07:34
 * @version 1.0
 */
public class BestTimeToBuyAndSellStockWithCooldownSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final int EMPTY = 0;
    private static final int HOLDING = 1;
    private static final int COOLING = 2;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[3][n];
        dp[HOLDING][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[EMPTY][i] = Math.max(dp[EMPTY][i - 1], dp[COOLING][i - 1]);
            dp[HOLDING][i] = Math.max(dp[HOLDING][i - 1], dp[EMPTY][i - 1] - prices[i]);
            dp[COOLING][i] = dp[HOLDING][i - 1] + prices[i];
        }
        return Math.max(dp[EMPTY][n - 1], dp[COOLING][n - 1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
