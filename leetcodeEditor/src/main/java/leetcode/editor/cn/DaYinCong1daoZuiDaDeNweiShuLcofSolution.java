package leetcode.editor.cn;

import java.util.*;

/**
 * 打印从1到最大的n位数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-25 15:02:47
 */
public class DaYinCong1daoZuiDaDeNweiShuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] printNumbers(int n) {
        int last = (int) (Math.pow(10, n) - 1);
        int[] res = new int[last];
        for (int i = 0; i < last; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
