package leetcode.editor.cn;

import java.util.*;

/**
 * 求1+2+…+n
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-14 12:45:35
 */
public class Qiu12nLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumNums(int n) {
        boolean flag = n == 1 || (n += sumNums(n - 1)) == 0;
        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
