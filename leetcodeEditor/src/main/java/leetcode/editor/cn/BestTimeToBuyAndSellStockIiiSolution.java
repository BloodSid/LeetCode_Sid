package leetcode.editor.cn;
//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁵ 
// 
//
// 👍 1614 👎 0


import java.util.*;

/**
 * 买卖股票的最佳时机 III
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-10-30 14:54:18 
 */
public class BestTimeToBuyAndSellStockIiiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static final int INF = (int) (1e9 + 7);

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
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
