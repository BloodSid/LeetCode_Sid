package Contest1209.T2;

/**
 * @author IronSid
 * @since 2023-12-09 22:16
 */
public class Solution {
    public int removeAlmostEqualCharacters(String word) {
        char[] ch = word.toCharArray();
        int res = 0;
        int n = ch.length;
        for (int i = 1; i < n; i++) {
            if (d(ch[i], ch[i - 1]) <= 1) {
                res++;
                while (d(ch[i], ch[i - 1]) <= 1 || (i < n - 1 && d(ch[i], ch[i + 1]) <= 1)) {
                    ch[i] = (ch[i] == 'z' ? 'a' : (char) (ch[i] + 1));
                }
            }
        }
        return res;
    }

    int d(char a, char b) {
        return Math.abs(a - b);
    }
}
