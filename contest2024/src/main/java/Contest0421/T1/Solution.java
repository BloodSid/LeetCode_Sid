package Contest0421.T1;

/**
 * @author IronSid
 * @since 2024-04-21 9:39
 */
public class Solution {
    public int numberOfSpecialChars(String word) {
        int[] f = new int[128];
        for (char c : word.toCharArray()) {
            f[c]++;
        }
        int res = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            if (f[c]>0 && f[c + 32] > 0) res++;
        }
        return res;
    }
}
