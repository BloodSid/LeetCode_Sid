package Contest0828.T2;

/**
 * @author IronSid
 * @since 2022-08-28 0:33
 */
public class Solution {
    public String removeStars(String s) {
        char[] ch = s.toCharArray();
        char[] res = new char[ch.length];
        int p = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '*') {
                p--;
            } else {
                res[p++] = ch[i];
            }
        }
        return new String(res, 0, p);
    }
}
