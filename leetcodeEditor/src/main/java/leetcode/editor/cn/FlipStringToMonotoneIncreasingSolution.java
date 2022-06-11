package leetcode.editor.cn;
//如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。 
//
// 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。 
//
// 返回使 s 单调递增的最小翻转次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "00110"
//输出：1
//解释：翻转最后一位得到 00111.
// 
//
// 示例 2： 
//
// 
//输入：s = "010110"
//输出：2
//解释：翻转得到 011111，或者是 000111。
// 
//
// 示例 3： 
//
// 
//输入：s = "00011000"
//输出：2
//解释：翻转得到 00000000。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 为 '0' 或 '1' 
// 
// 👍 249 👎 0


/**
 * 将字符串翻转到单调递增
 *
 * @author IronSid
 * @since 2022-06-11 21:34:40 
 * @version 1.0
 */
public class FlipStringToMonotoneIncreasingSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFlipsMonoIncr(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[][] dp = new int[2][n];
        dp[0][0] = ch[0] == '0' ? 0 : 1;
        dp[1][0] = ch[0] == '1' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            if (ch[i] == '1') dp[0][i] = dp[0][i - 1] + 1;
            else  dp[0][i] = dp[0][i - 1];
            if (ch[i] == '1') dp[1][i] = Math.min(dp[0][i - 1], dp[1][i - 1]);
            else dp[1][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + 1;
        }
        return Math.min(dp[0][n - 1], dp[1][n - 1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
