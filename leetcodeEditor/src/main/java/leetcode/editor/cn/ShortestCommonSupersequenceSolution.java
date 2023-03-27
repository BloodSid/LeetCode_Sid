package leetcode.editor.cn;
//给出两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。 
//
// （如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T 的子序列） 
//
// 
//
// 示例： 
//
// 输入：str1 = "abac", str2 = "cab"
//输出："cabac"
//解释：
//str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。 
//str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
//最终我们给出的答案是满足上述属性的最短字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= str1.length, str2.length <= 1000 
// str1 和 str2 都由小写英文字母组成。 
// 
// 👍 122 👎 0


/**
 * 最短公共超序列
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-03-28 00:40:51 
 */
public class ShortestCommonSupersequenceSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int m = c1.length, n = c2.length;
        // 求最长公共子序列
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (c1[i] == c2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        StringBuilder lcs = new StringBuilder();
        for (int i = m - 1, j = n - 1; i >= 0 && j >= 0; ) {
            if (c1[i] == c2[j]) {
                lcs.append(c1[i]);
                i--;
                j--;
            } else {
                if (dp[i + 1][j + 1] == dp[i][j + 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        lcs.reverse();
        StringBuilder sb = new StringBuilder();
        int i0 = -1, j0 = -1;
        for (int i1 = 0, j1 = 0, k = 0; k < lcs.length(); k++) {
            char c = lcs.charAt(k);
            while (c1[i1] != c) i1++;
            while (c2[j1] != c) j1++;
            sb.append(c1, i0 + 1, i1 - i0 - 1);
            i0 = i1;
            sb.append(c2, j0 + 1, j1 - j0 - 1);
            j0 = j1;
            sb.append(c);
            i1++;
            j1++;
        }
        sb.append(c1, i0 + 1, c1.length - 1 - i0);
        sb.append(c2, j0 + 1, c2.length - 1 - j0);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
