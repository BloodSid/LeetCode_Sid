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
        for (long i = 0, j = (int) Math.sqrt(c); i <= j; ) {
            long sum = i * i + j * j;
            if (sum == c) {
                return true;
            }
            if (sum > c) j--;
            else i++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
