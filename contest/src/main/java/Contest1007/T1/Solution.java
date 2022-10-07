package Contest1007.T1;

/**
 * @author IronSid
 * @since 2022-10-07 23:21
 */
public class Solution {
    public int minNumBooths(String[] demand) {
        int[] res = new int[26];
        for (String s : demand) {
            int[] f = new int[26];
            for (char c : s.toCharArray()) {
                f[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                res[i] = Math.max(res[i], f[i]);
            }
        }
        int sum = 0;
        for (int re : res) {
            sum += re;
        }
        return sum;
    }
}
