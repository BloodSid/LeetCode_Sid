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
        boolean[][] dp = new boolean[n][n];
        int max = 1;
        int start = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i <= n - 2; i++) {
            if (ch[i] == ch[i + 1]) {
                dp[i][i + 1] = true;
                max = 2;
                start = i;
            }
        }
        for (int cnt = 3; cnt <= n; cnt++) {
            for (int i = 0; i <= n - cnt; i++) {
                int j = i + cnt - 1;
                if (ch[i] == ch[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    max = cnt;
                    start = i;
                }
            }
        }
        return new String(ch, start, max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
