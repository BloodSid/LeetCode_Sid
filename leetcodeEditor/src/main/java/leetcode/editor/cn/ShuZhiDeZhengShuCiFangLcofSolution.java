package leetcode.editor.cn;

import java.util.*;

/**
 * 数值的整数次方
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-15 14:08:16
 */
public class ShuZhiDeZhengShuCiFangLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else if (n > 0) {
            return myPow(x * x, n / 2) * x;
        } else
            return myPow(x * x, n / 2) / x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
