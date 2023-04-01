package Contest0401.T2;

/**
 * @author IronSid
 * @since 2023-04-01 23:29
 */
public class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] val = new int[128];
        for (char c = 'a'; c <= 'z'; c++) {
            int i = chars.indexOf(c);
            if (i < 0) {
                val[c] = c - 'a' + 1;
            } else {
                val[c] = vals[i];
            }
        }
        int max = 0;
        int dp = 0;
        for (char c : s.toCharArray()) {
            dp = Math.max(dp + val[c], val[c]);
            max = Math.max(max, dp);
        }
        return max;
    }
}
