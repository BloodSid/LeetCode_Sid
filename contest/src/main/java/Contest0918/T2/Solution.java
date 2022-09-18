package Contest0918.T2;

/**
 * @author IronSid
 * @since 2022-09-18 10:28
 */
public class Solution {
    public int longestContinuousSubstring(String s) {
        char[] ch = s.toCharArray();
        int max = 1;
        for (int i = 1, dp = 1; i < ch.length; i++) {
            if (ch[i] == ch[i - 1] + 1) {
                dp++;
                max = Math.max(max, dp);
            } else {
                dp = 1;
            }
        }
        return max;
    }
}
