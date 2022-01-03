package leetcode.editor.cn;

import java.util.*;

/**
 * 股票的最大利润
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-03 16:25:18
 */
public class GuPiaoDeZuiDaLiRunLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
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
