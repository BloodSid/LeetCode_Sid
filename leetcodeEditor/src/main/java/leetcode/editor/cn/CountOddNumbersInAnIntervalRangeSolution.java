package leetcode.editor.cn;

import java.util.*;

/**
 * 在区间范围内统计奇数数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-08 00:27:29
 */
public class CountOddNumbersInAnIntervalRangeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countOdds(int low, int high) {
        if ((low & 1) == 0) {
            low++;
        }
        if ((high & 1) == 0) {
            high--;
        }
        return ((high - low) >> 1) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
