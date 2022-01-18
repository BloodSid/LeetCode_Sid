package leetcode.editor.cn;

import java.util.*;

/**
 * 圆圈中最后剩下的数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-18 16:35:27
 */
public class YuanQuanZhongZuiHouShengXiaDeShuZiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n, int m) {
        // f(1, k) = 0
        int f = 0;
        // f(n, k) = (f(n - 1, k) + k) % n
        for (int i = 2; i <= n; i++) {
            f = (f + m) % i;
        }
        return f;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
