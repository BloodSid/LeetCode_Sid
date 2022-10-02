package Contest1002.T4;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2022-10-02 10:36
 */
public class Solution {
    public int deleteString(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        HashMap<Character, Integer> f = new HashMap<>();
        for (int i = 0; i < n; i++) {
            f.put(ch[i], f.getOrDefault(ch[i], 0) + 1);
        }
        if (f.size() == 1) return n;
        int[] dp = new int[n];
        int maxD = 0;
        for (int j = 0; j < n; j++) {
            for (int i = Math.max(0, 2 * j - n); i < j; i++) {
                if (i != 0 && dp[i] == 0) continue;
                int k;
                for (k = 0; k < j - i; k++) {
                    if (ch[i + k] != ch[j + k]) break;
                }
                if (k == j - i) dp[j] = Math.max(dp[j], dp[i] + 1);
            }
            maxD = Math.max(maxD, dp[j]);
        }
        return maxD + 1;
    }
}
