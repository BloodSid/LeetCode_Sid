package leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// 👍 5305 👎 0


/**
 * 最长回文子串
 *
 * @author IronSid
 * @since 2022-06-09 23:51:32 
 * @version 1.0
 */
public class LongestPalindromicSubstringSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int ODD = 0;
    public static final int EVEN = 1;

    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[][] dp = new int[2][n];
        int max = 0;
        int endI = 0, endK = 0;
        dp[ODD][0] = 1;
        for (int i = 1; i < n; i++) {
            dp[ODD][i] = 1;
            if (ch[i] == ch[i - 1]) dp[EVEN][i] = 2;
            for (int k = 0; k < 2; k++) {
                int start = i - 1 - dp[k][i - 1];
                if (start >= 0 && ch[start] == ch[i]) {
                    dp[k][i] = dp[k][i - 1] + 2;
                }
                if (dp[k][i] > max) {
                    max = dp[k][i];
                    endI = i;
                    endK = k;
                }
            }
        }
        return new String(ch, endI - dp[endK][endI] + 1, dp[endK][endI]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
