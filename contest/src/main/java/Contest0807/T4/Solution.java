package Contest0807.T4;

/**
 * @author IronSid
 * @since 2022-08-07 10:24
 */
public class Solution {
    public int longestIdealString(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[] dp = new int[26];
        dp[ch[0] - 'a'] = 1;
        for (int i = 1; i < n; i++) {
            int cur = ch[i] - 'a';
            int t = 0;
            for (int p = Math.max(0, cur - k); p <= Math.min(25, cur + k); p++) {
                t = Math.max(t, dp[p]);
            }
            dp[cur] = t + 1;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
