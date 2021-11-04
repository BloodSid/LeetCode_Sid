package leetcode.editor.cn;

import java.util.*;

/**
 * 有效的完全平方数
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-04 11:01:32
 */
public class ValidPerfectSquareSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        int l = 0;
        int r = num;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            long sqr = (long) mid * mid;
            if (sqr < num) {
                l = mid + 1;
            } else if (sqr > num) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
