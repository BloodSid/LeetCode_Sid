package leetcode.editor.cn;

/**
 * 平方数之和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-19 09:32:12
 */
public class SumOfSquareNumbersSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean judgeSquareSum(int c) {
        for (int factor = 2; factor <= c / factor; factor++) {
            int cnt = 0;
            while (c % factor == 0) {
                c /= factor;
                cnt++;
            }
            if (cnt % 2 == 1 && factor % 4 == 3) {
                return false;
            }
        }
        return c % 4 != 3;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
