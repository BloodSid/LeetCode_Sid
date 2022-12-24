package Contest1224.T4;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author IronSid
 * @since 2022-12-24 22:45
 */
public class Solution {

    public static final int MOD = (int) (1e9 + 7);
    static HashMap<Integer, HashMap<Integer, Integer>> C = new HashMap<>();

    public int countAnagrams(String str) {
        long res = 1;
        char[] s = str.toCharArray();
        int[] f = new int[26];
        // 单词的长度
        int len = 0;
        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                // 排列数
                long cnt = 1;
                for (int c : f) {
                    if (c != 0) {
                        cnt = cnt * C(len, c) % MOD;
                        len -= c;
                    }
                }
                res = res * cnt % MOD;
                // 到结尾处终止
                if (i == s.length) break;
                Arrays.fill(f, 0);
                len = 0;
            } else {
                f[s[i] - 'a']++;
                len++;
            }
        }
        return (int) res;
    }

    public long C(int n, int m) {
        if (m == 0) return 1;
        if (m == n) return 1;
        m = Math.min(m, n - m);
        if (!C.containsKey(n)) C.put(n, new HashMap<>());
        if (!C.get(n).containsKey(m)) {
            // C(n,m) = C(n-1, m-1) + C(n-1, m)
            C.get(n).put(m, (int) ((C(n - 1, m - 1) + C(n - 1, m)) % MOD));
        }
        return C.get(n).get(m);
    }
}
