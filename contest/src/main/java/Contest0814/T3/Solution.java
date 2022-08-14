package Contest0814.T3;

/**
 * @author IronSid
 * @since 2022-08-14 10:23
 */
public class Solution {
    public String smallestNumber(String pattern) {
        char[] ch = pattern.toCharArray();
        char[] res = new char[ch.length + 1];
        char max = '1';
        res[0] = '1';
        for (int i = 1; i < res.length; i++) {
            if (ch[i - 1] == 'I') {
                res[i] = ++max;
            } else {
                int j = i;
                while (j < ch.length && ch[j] == 'D') j++;
                for (int k = j; k >= i - 1; k--) {
                    res[k] = max++;
                }
                max--;
                i = j;
            }
        }
        return new String(res);
    }
}
