package leetcode.editor.cn;

import java.util.*;

/**
 * 买卖股票的最佳时机
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-29 20:40:12
 */
public class BestTimeToBuyAndSellStockSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
