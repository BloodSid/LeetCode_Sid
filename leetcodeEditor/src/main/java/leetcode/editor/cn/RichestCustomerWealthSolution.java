package leetcode.editor.cn;

import java.util.*;
import java.util.function.Consumer;

/**
 * 最富有客户的资产总量
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-11 15:44:54
 */
public class RichestCustomerWealthSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int max = 0;
    Consumer<int[]> getMax = o -> {
        int sum = 0;
        for (int i : o) {
            sum += i;
        }
        max = Math.max(max, sum);
    };

    public int maximumWealth(int[][] accounts) {
        Arrays.asList(accounts).forEach(getMax);
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
