package Contest0430.T4;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2023-04-30 10:34
 */
public class Solution {

    private char[] res;
    private char limit;
    private char[] c;

    public String smallestBeautifulString(String s, int k) {
        limit = (char) ('a' + k - 1);
        char[] t = new char[s.length()];
        Arrays.fill(t, (char) ('a' + k - 1));
        for (int i = 0; i < t.length; i++) {
            t[i] -= i % 3;
        }
        String max = new String(t);
        if (s.compareTo(max) >= 0) return "";
        int n = s.length();
        c = s.toCharArray();
        res = new char[n];
        // 找到第一个回文出现的位置
        dfs(0, (char) 0, (char) 0);
        // 空的位置全用abc填充
        int i;
        for (i = 0; i < n; i++) {
            if (res[i] == 0) break;
        }
        for (; i < n; i++) {
            res[i] = 'a';
            while ((i >= 1 && res[i - 1] == res[i]) || (i >= 2 && res[i - 2] == res[i])) {
                res[i]++;
            }
        }
        return new String(res);
    }

    boolean dfs(int i, char p1, char p2) {
        if (i == res.length) {
            return false;
        }
        for (char a = c[i]; a <= limit; a++) {
            if (a == p1 || a == p2) continue;
            res[i] = a;
            if (res[i] != c[i]) return true;
            if (dfs(i + 1, p2, a)) {
                return true;
            }
        }
        res[i] = 0;
        return false;
    }
}
