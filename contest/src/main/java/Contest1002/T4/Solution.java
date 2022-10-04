package Contest1002.T4;

/**
 * @author IronSid
 * @since 2022-10-02 10:36
 */
public class Solution {
    public int deleteString(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        // dp[i] 表示删至剩余 s[i:] 的最大步数
        int[] dp = new int[n];
        //  lcp[i][j] 表示 s[i:] 和 s[j:] 的最长公共后缀
        int[][] lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (ch[i] == ch[j]) lcp[i][j] = lcp[i + 1][j + 1] + 1;
            }
        }
        int maxD = 0;
        for (int j = 0; j < n; j++) {
            for (int i = Math.max(0, 2 * j - n); i < j; i++) {
                // 如果没有办法通过若干步操作达到剩余 s[i:] 的状态，则跳过
                if (i != 0 && dp[i] == 0) continue;
                // s[i:] 和 s[j:] 有相同前缀，表示从 dp[i] 到 dp[j] 的状态转移成立
                if (lcp[i][j] >= j - i) dp[j] = Math.max(dp[j], dp[i] + 1);
            }
            maxD = Math.max(maxD, dp[j]);
        }
        // 任何位置都可以一步操作删除整个字符串，所以找出步数最大的位置再操作一步就是结果
        return maxD + 1;
    }
}
