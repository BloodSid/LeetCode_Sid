package leetcode.editor.cn;

import java.util.*;

/**
 * 消除游戏
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-02 18:51:32
 */
public class EliminationGameSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n) {
        int len = n;
        int start = 1;
        int gap = 1;
        boolean leftToRight = true;
        while (len > 1) {
            // 仅在数列有偶数项且从右往左删的时候，第一项不被删；其他情况第一项被删，原来的第二项变成第一项
            if (len % 2 == 1 || leftToRight) {
                start += gap;
            }
            len /= 2;
            gap *= 2;
            leftToRight = !leftToRight;
        }
        return start;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
