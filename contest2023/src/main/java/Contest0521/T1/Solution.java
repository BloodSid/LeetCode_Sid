package Contest0521.T1;

/**
 * @author IronSid
 * @since 2023-05-21 10:21
 */
public class Solution {
    public int minLength(String s) {
        char[] res = new char[s.length()];
        int p = 0;
        // 栈
        for (char c : s.toCharArray()) {
            char top = p != 0 ? res[p - 1] : 0;
            if (c == 'B' && top == 'A' || c == 'D' && top == 'C') {
                // 出栈
                p--;
            } else {
                res[p++] = c;
            }
        }
        return p;
    }
}
