package Contest0528.T3;

/**
 * @author IronSid
 * @since 2023-05-28 10:29
 */
public class Solution {
    public long minimumCost(String s) {
        long ans = 0;
        char[] c = s.toCharArray();
        int n = c.length;
        if (n == 1) return 0;
        if (n == 2) return c[0] == c[1] ? 0 : 1;
        for (int i = 1, j = n - 2; i <= j; i++, j--) {
            if (c[i] != c[i - 1]) {
                ans += i;
            }
            if (c[j] != c[j + 1]) {
                ans += i;
            }
            if (i + 1 == j && c[i] != c[j]) {
                ans += i + 1;
            }
        }
        return ans;
    }
}
