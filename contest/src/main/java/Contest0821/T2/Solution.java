package Contest0821.T2;

/**
 * @author IronSid
 * @since 2022-08-21 9:54
 */
public class Solution {
    public String largestPalindromic(String num) {
        char[] ch = num.toCharArray();
        int[] f = new int[10];
        for (char c : ch) f[c - '0']++;
        StringBuilder pre = new StringBuilder();
        for (int i = 9; i > 0; i--) {
            for (int j = 0; j < f[i] / 2; j++) {
                pre.append(i);
            }
        }
        if (pre.length() > 0) for (int j = 0; j < f[0] / 2; j++) pre.append(0);
        StringBuilder suf = new StringBuilder(pre);
        suf.reverse();
        for (int i = 9; i >= 0; i--) {
            if (f[i] % 2 == 1) {
                pre.append(i);
                break;
            }
        }
        if (pre.length() == 0) pre.append(0);
        String res = pre.append(suf).toString();
        return res;
    }
}
