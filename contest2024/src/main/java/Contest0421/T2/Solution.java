package Contest0421.T2;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2024-04-21 9:39
 */
public class Solution {
    public int numberOfSpecialChars(String word) {
        int[] last = new int[128];
        Arrays.fill(last, -1);
        char[] ch = word.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'a' && ch[i] <= 'z') {
                last[ch[i]] = i;
            } else {
                if (last[ch[i]] == -1) {
                    last[ch[i]] = i;
                }
            }
        }
        int res = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            if (last[c] >= 0 && last[c + 32] >= 0 && last[c + 32] < last[c]) {
                res++;
            }

        }
        return res;
    }
}
