package leetcode.editor.cn;

import java.util.*;

/**
 * 找出游戏的获胜者
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-17 01:01:16
 */
public class FindTheWinnerOfTheCircularGameSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTheWinner(int n, int k) {
        // f(1, k) = 1
        int f = 1;
        // f(n, k) = (f(n - 1, k) + k) % n
        // 防止刚好整除的情形导致取模为0，对原值-1后再对模+1
        for (int i = 2; i <= n; i++) {
            f = (f + k - 1) % i + 1;
        }
        return f;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
