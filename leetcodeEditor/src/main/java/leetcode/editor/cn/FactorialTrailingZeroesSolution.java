package leetcode.editor.cn;

/**
 * 阶乘后的零
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-25 00:01:02 
 */
public class FactorialTrailingZeroesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        int divisor = 5;
        for (int i = 0; i < 10; i++) {
            cnt += n / divisor;
            divisor *= 5;
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
