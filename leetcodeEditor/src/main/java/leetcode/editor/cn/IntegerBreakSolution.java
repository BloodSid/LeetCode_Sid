package leetcode.editor.cn;
//给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。 
//
// 返回 你可以获得的最大乘积 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 
//输入: n = 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 
//
// 提示: 
//
// 
// 2 <= n <= 58 
// 
// 👍 839 👎 0


/**
 * 整数拆分
 *
 * @author IronSid
 * @since 2022-06-09 23:57:48 
 * @version 1.0
 */
public class IntegerBreakSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        switch (n % 3) {
            case 0:
                return (int) Math.pow(3, n / 3);
            case 1:
                return 4 * (int) Math.pow(3, (n - 4) / 3);
            case 2:
                return 2 * (int) Math.pow(3, (n - 2) / 3);
            default:
                return -1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
