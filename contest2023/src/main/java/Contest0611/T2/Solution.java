package Contest0611.T2;

/**
 * @author IronSid
 * @since 2023-06-11 10:29
 */
public class Solution {
    public String smallestString(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        int n = c.length;
        for (; i < n; i++) {
            if (c[i] != 'a') break;
        }
        // 若全是a，则最后一个字母变为z
        if (i == n) c[n - 1] = 'z';
        for (; i < n; i++) {
            if (c[i] == 'a') break;
            c[i]--;
        }
        return new String(c);
    }
}
