package Contest1113.T4;

/**
 * @author IronSid
 * @since 2022-11-13 10:30
 */
public class Solution {
    public int maxPalindromes(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        // dp[i][j] 表示 s[i:j] 是否回文
        boolean[][] dp = new boolean[n][n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i <= n - 2; i++) {
            if (ch[i] == ch[i + 1]) {
                dp[i][i + 1] = true;
                max = 2;
            }
        }
        for (int cnt = 3; cnt <= n; cnt++) {
            boolean found = false;
            for (int i = 0; i <= n - cnt; i++) {
                int j = i + cnt - 1;
                if (ch[i] == ch[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    max = cnt;
                    found = true;
                }
            }
            // 如果max + 1 和 max + 2 的长度都没有回文子串，那么就一定不会有更长的回文子串
            if (!found && cnt - max >= 2) break;
        }
        int res = 0;
        // 贪心得匹配 k 和 k + 1 长度的回文串
        for (int i = 0; i < ch.length; ) {
            if (i + k - 1 < n && dp[i][i + k - 1]) {
                res++;
                i += k;
            } else if (i + k < n && dp[i][i + k]) {
                res++;
                i += k + 1;
            } else {
                i++;
            }
        }
        return res;
    }
}
