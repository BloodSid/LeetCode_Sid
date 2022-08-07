package Contest0807.T4;

/**
 * @author IronSid
 * @since 2022-08-07 10:24
 */
public class Solution {
    public int longestIdealString(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[][] dp = new int[26][n];
        dp[ch[0] - 'a'][0] = 1;
        for (int i = 0; i < n - 1; i++) {
            int next = ch[i + 1] - 'a';
            for (int j = 0; j < 26; j++) {
                if (Math.abs(j - next) <= k) dp[next][i + 1] = Math.max(dp[next][i + 1], dp[j][i] + 1);
                if (j != next) dp[j][i + 1] = dp[j][i];
            }
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, dp[i][n - 1]);
        }
        return max;
    }
}
