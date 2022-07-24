package Contest0724.T1;

/**
 * @author IronSid
 * @since 2022-07-24 10:24
 */
public class Solution {
    public char repeatedCharacter(String s) {
        char[] ch = s.toCharArray();
        int[] f = new int[128];
        for (char c : ch) {
            f[c]++;
            if (f[c] == 2) return c;
        }
        return 0;
    }
}
