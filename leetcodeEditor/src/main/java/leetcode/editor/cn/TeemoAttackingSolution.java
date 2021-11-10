package leetcode.editor.cn;

import java.util.*;

/**
 * 提莫攻击
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-10 13:00:40 
 */
public class TeemoAttackingSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            int gap = timeSeries[i] - timeSeries[i - 1];
            if (gap < duration) {
                ans += gap;
            } else {
                ans += duration;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
