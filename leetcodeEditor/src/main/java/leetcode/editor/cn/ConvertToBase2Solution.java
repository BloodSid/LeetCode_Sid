package leetcode.editor.cn;
//给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。 
//
// 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出："110"
//解释：(-2)² + (-2)¹ = 2
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出："111"
//解释：(-2)² + (-2)¹ + (-2)⁰ = 3
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出："100"
//解释：(-2)² = 4
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁹ 
// 
//
// 👍 130 👎 0


/**
 * 负二进制转换
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-04-06 17:32:30 
 */
public class ConvertToBase2Solution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String baseNeg2(long n) {
        long ans = 0;
        int i = 0;
        while (n != 0) {
            if ((n >> i & 1) == 1) {
                ans |= 1L << i;
                if ((i & 1) == 0) {
                    // 偶数位上有1, 该位对结果贡献为正数
                    n -= 1L << i;
                } else {
                    // 奇数位上有1，该位对结果贡献为负数
                    n += 1L << i;
                }
            }
            i++;
        }
        return Long.toBinaryString(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
