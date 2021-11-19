package leetcode.editor.cn;

import java.util.*;

/**
 * 整数替换
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-19 16:53:20
 */
public class IntegerReplacementSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerReplacement(int n) {
        int cnt = 0;
        while (n > 1) {
            if (n == Integer.MAX_VALUE) {
                // 对于0x7FFFFFFF，应该先+1再除以2，但是+1会溢出，所以变形成下式运算
                n = (n >> 1) + 1;
                // 这里操作了两步
                cnt++;
            } else if ((n & 1) == 0) {
                n >>= 1;
                // 3的二进制是11，对于末尾是11的数，应该+1。例外是3本身，因为终点是1，所以3应该-1
            } else if ((n & 3) == 3 && n != 3) {
                n++;
            } else {
                n--;
            }
            cnt++;
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
