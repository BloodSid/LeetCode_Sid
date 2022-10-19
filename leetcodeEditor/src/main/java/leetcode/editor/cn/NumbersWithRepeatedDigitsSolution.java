package leetcode.editor.cn;
//给定正整数 n，返回在 [1, n] 范围内具有 至少 1 位 重复数字的正整数的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 20
//输出：1
//解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
// 
//
// 示例 2： 
//
// 
//输入：n = 100
//输出：10
//解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
// 
//
// 示例 3： 
//
// 
//输入：n = 1000
//输出：262
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 
// 👍 109 👎 0


import java.util.Arrays;

/**
 * 至少有 1 位重复的数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-14 12:27:05 
 */
public class NumbersWithRepeatedDigitsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private char[] s;
    private int[][] dp;

    public int numDupDigitsAtMostN(int n) {
        // 计算结果的补集：没有重复的数字
        s = Integer.toString(n).toCharArray();
        for (int i = 0; i < s.length; i++) {
            s[i] -= '0';
        }
        dp = new int[s.length][1 << 10];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return n - f(0, 0, false, true);
    }

    int f(int i, int mask, boolean isNum, boolean isLimited) {
        if (i == s.length) return isNum ? 1 : 0;
        if (isNum && !isLimited && dp[i][mask] != -1) return dp[i][mask];
        int res = 0;
        if (!isNum) res += f(i + 1, mask, false, false);
        int down = isNum ? 0 : 1;
        int up = isLimited ? s[i] : 9;
        for (int d = down; d <= up; d++) {
            if ((mask >> d & 1) == 0) {
                res += f(i + 1, mask | 1 << d, true, isLimited && d == s[i]);
            }
        }
        if (isNum && !isLimited) dp[i][mask] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
