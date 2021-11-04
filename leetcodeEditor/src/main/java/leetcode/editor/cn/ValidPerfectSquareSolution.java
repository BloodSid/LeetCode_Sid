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
        for (int factor = 2; factor <= num / factor; factor++) {
            int cnt = 0;
            while (num % factor == 0) {
                num /= factor;
                cnt++;
            }
            if (cnt % 2 == 1) {
                return false;
            }
        }
        return num == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
