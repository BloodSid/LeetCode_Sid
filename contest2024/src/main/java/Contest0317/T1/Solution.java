package Contest0317.T1;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2024-03-17 10:22
 */
public class Solution {
    public boolean isSubstringPresent(String s) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            set.add(s.substring(i, i + 2));
        }
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            char t = c[i];
            c[i] = c[j];
            c[j] = t;
        }
        for (int i = 0; i < c.length - 1; i++) {
            if (set.contains(new String(c, i, 2))) {
                return true;
            }
        }
        return false;
    }
}
