package Contest0619;

/**
 * @author IronSid
 * @since 2022-06-19 9:28
 */
public class Solution {
    // T1
    public String greatestLetter(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[] f = new int[128];
        for (int i = 0; i < n; i++) {
            f[ch[i]]++;
        }
        for (char c = 'Z'; c >= 'A'; c--) {
            if (f[c] > 0 && f[c + 32] > 0) return String.valueOf(c);
        }
        return "";
    }
    // T2
    public int minimumNumbers(int num, int k) {
        if (num == 0) return 0;
        for (int i = 1; i <= 10; i++) {
            if (i * k % 10 == num % 10 && i * k <= num) return i;
        }
        return -1;
    }
    // T3
    public int longestSubsequence(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        // 前导零
        int[] pre = new int[n];
        for (int i = 0, cnt = 0; i < n; i++) {
            pre[i] = cnt;
            if (ch[i] == '0') cnt++;
        }
        // dp[i][j] : ch[i]做序列中的第一个，序列长度 j 子序列的最小值
        int[][] dp = new int[n][32];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i][1] = ch[i] - '0';
            if (dp[i][1] <= k) max = Math.max(max, 1 + pre[i]);
        }
        for (int len = 2; len < 32; len++) {
            for (int i = n - len; i >= 0; i--) {
                int min = Integer.MAX_VALUE;
                for (int i1 = i + 1; i1 <= n - len + 1; i1++) {
                    min = Math.min(min, dp[i1][len - 1]);
                }
                if (ch[i] == '0') {
                    dp[i][len] = min;
                } else {
                    dp[i][len] = min + (1 << (len - 1));
                }
                if (dp[i][len] <= k) max = Math.max(max, len + pre[i]);
            }
        }
        return max;
    }
    // T4
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m + 1][n + 1];
        for (int[] price : prices) {
            dp[price[0]][price[1]] = price[2];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                long max = 0;
                for (int k = 1; k <= i / 2; k++) {
                    max = Math.max(max, dp[k][j] + dp[i - k][j]);
                }
                for (int k = 1; k <= j / 2; k++) {
                    max = Math.max(max, dp[i][k] + dp[i][j - k]);
                }
                dp[i][j] = Math.max(dp[i][j], max);
            }
        }
        return dp[m][n];
    }
}
