package leetcode.editor.cn;
//给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 5
//输出: 2
//解释: 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。 
//
// 示例 2: 
//
// 
//输入: n = 9
//输出: 3
//解释: 9 = 4 + 5 = 2 + 3 + 4 
//
// 示例 3: 
//
// 
//输入: n = 15
//输出: 4
//解释: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 10⁹ 
// 
// 👍 165 👎 0


/**
 * 连续整数求和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-03 09:37:27
 */
public class ConsecutiveNumbersSumSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int consecutiveNumbersSum(int n) {
        // 它自身
        int cnt = 1;
        // n * 2 = (2 * a + i - 1) * i
        n <<= 1;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                int j = n / i;
                if (j + 1 - i >= 2 && ((j + 1 - i) % 2 == 0)) cnt++;
                if (i + 1 - j >= 2 && ((i + 1 - j) % 2 == 0)) cnt++;
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
