package leetcode.editor.cn;
//给定一个字符串 s，返回 s 中不同的非空「回文子序列」个数 。 
//
// 通过从 s 中删除 0 个或多个字符来获得子序列。 
//
// 如果一个字符序列与它反转后的字符序列一致，那么它是「回文字符序列」。 
//
// 如果有某个 i , 满足 ai != bi ，则两个序列 a1, a2, ... 和 b1, b2, ... 不同。 
//
// 注意： 
//
// 
// 结果可能很大，你需要对 10⁹ + 7 取模 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = 'bccb'
//输出：6
//解释：6 个不同的非空回文子字符序列分别为：'b', 'c', 'bb', 'cc', 'bcb', 'bccb'。
//注意：'bcb' 虽然出现两次但仅计数一次。
// 
//
// 示例 2： 
//
// 
//输入：s = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
//输出：104860361
//解释：共有 3104860382 个不同的非空回文子序列，104860361 对 10⁹ + 7 取模后的值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s[i] 仅包含 'a', 'b', 'c' 或 'd' 
// 
// 👍 254 👎 0


/**
 * 统计不同回文子序列
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-10 18:05:54
 */
public class CountDifferentPalindromicSubsequencesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int MOD = (int) 1e9 + 7;
    //字符集大小
    public static final int C = 4;

    public int countPalindromicSubsequences(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[][][] dp = new int[C][n][n];
        // 初始化
        for (int c = 0; c < C; c++) {
            char cur = (char) ('a' + c);
            for (int i = 0; i < n; i++) {
                if (ch[i] == cur) dp[c][i][i] = 1;
            }
        }
        // 动态规划
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int c = 0; c < C; c++) {
                    char x = (char) ('a' + c);
                    if (x == ch[i] && x == ch[j]) {
                        // 新构成的子序列包括 "x", "xx", 和在之前的子序列前后各加一个 'x'
                        long temp = 2;
                        for (int d = 0; d < C; d++) {
                            temp += dp[d][i + 1][j - 1];
                        }
                        dp[c][i][j] = (int) (temp % MOD);
                    } else if (x == ch[i]) {
                        dp[c][i][j] = dp[c][i][j - 1];
                    } else if (x == ch[j]) {
                        dp[c][i][j] = dp[c][i + 1][j];
                    } else {
                        dp[c][i][j] = dp[c][i + 1][j - 1];
                    }
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < C; i++) {
            sum += dp[i][0][n - 1];
        }
        return (int) (sum % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
