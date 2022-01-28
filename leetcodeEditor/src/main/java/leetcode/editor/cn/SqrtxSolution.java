package leetcode.editor.cn;

import java.util.*;

/**
 * Sqrt(x)
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-28 22:25:11
 */
public class SqrtxSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        double a = x, b = 0.0;
        do {
            b = a;
            a = (a + x / a) / 2;
        } while (b - a > 1e-5);
        return (int) a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
