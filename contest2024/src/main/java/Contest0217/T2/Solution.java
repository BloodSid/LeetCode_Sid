package Contest0217.T2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2024-02-17 22:03
 */
public class Solution {
    public String lastNonEmptyString(String s) {
        char[] c = s.toCharArray();
        int[] f = new int[128];
        int[] last = new int[128];
        for (int i = 0; i < c.length; i++) {
            f[c[i]]++;
            last[c[i]] = i;
        }
        int maxF = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            maxF = Math.max(maxF, f[ch]);
        }
        List<Character> list = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (f[ch] == maxF) {
                list.add(ch);
            }
        }
        list.sort((a,b) -> last[a] - last[b]);
        StringBuilder sb = new StringBuilder();
        for (Character ch : list) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
