package leetcode.editor.cn;

import java.util.*;

/**
 * 范围求和 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-07 11:38:40 
 */
public class RangeAdditionIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int x = m;
        int y = n;
        for (int[] op : ops) {
            x = Math.min(x, op[0]);
            y = Math.min(y, op[1]);
        }
        return x * y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
