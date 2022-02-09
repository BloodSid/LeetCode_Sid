package leetcode.editor.cn;

import java.util.*;

/**
 * 快乐数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-09 22:33:18
 */
public class HappyNumberSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        int fast = getNext(getNext(n)), slow = getNext(n);
        while (fast != slow && fast != 1) {
            fast = getNext(getNext(fast));
            slow = getNext(slow);
        }
        return fast == 1;
    }

    int[] sq = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};

    int getNext(int n) {
        int sum = 0;
        for (; n != 0; n /= 10) {
            sum += sq[n % 10];
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
