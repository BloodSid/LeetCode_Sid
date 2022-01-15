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
        double pow = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                if (n > 0) {
                    pow *= x;
                } else {
                    pow /= x;
                }
            }
            n /= 2;
            x *= x;
        }
        return pow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
