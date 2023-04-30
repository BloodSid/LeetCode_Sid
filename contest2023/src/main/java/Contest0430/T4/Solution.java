package Contest0430.T4;

/**
 * @author IronSid
 * @since 2023-04-30 10:34
 */
public class Solution {

    public String smallestBeautifulString(String s, int k) {
        char limit = (char) ('a' + k - 1);
        int n = s.length();
        char[] c = s.toCharArray();
        // 找到需要增加的位置
        int i;
        for (i = 0; i < n; i++) {
            if (c[i] > limit || (i >= 1 && c[i - 1] == c[i]) || (i >= 2 && c[i - 2] == c[i])) {
                break;
            }
        }
        while (i >= 0) {
            if (i == n) {
                c[i - 1]++;
                i--;
                continue;
            }
            while ((i >= 1 && c[i - 1] == c[i]) || (i >= 2 && c[i - 2] == c[i])) {
                c[i]++;
            }
            if (c[i] > limit) {
                if (i >= 1) c[i - 1]++;
                i--;
            } else {
                // 找到了不修改的字母
                break;
            }
        }
        if (i == -1) return "";
        // c[i] 已经变大，c[i+1:]尽可能取小
        i++;
        for (; i < n; i++) {
            char ci = 'a';
            while ((i >= 1 && c[i - 1] == ci) || (i >= 2 && c[i - 2] == ci)) {
                ci++;
            }
            c[i] = ci;
        }
        return new String(c);
    }
}
