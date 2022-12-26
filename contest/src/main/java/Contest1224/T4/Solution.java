package Contest1224.T4;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2022-12-24 22:45
 */
public class Solution {

    public static final int MOD = (int) (1e9 + 7);
    // 阶乘 a!
    static long[] fac = new long[(int) (1e5 + 10)];
    // 阶乘的逆元, a! ^ (MOD - 2) % MOD, a的范围是[1,1e5], 易知逆元必不为零
    static long[] div = new long[(int) (1e5 + 10)];

    static {
        fac[0] = 1;
    }

    public int countAnagrams(String str) {
        long res = 1;
        char[] s = str.toCharArray();
        int[] f = new int[26];
        // 单词的长度
        int len = 0;
        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                // 排列数
                long cnt = fac(len);
                for (int c : f) {
                    if (c != 0) {
                        cnt = cnt * div(c) % MOD;
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

    long fac(int i) {
        if (fac[i] == 0) {
            int j = i;
            while (fac[j - 1] == 0) j--;
            for (; j <= i; j++) {
                fac[j] = fac[j - 1] * j % MOD;
            }
        }
        return fac[i];
    }

    // 快速幂
    long pow(long a, long b) {
        if (b == 0) return 1;
        long s = b % 2 == 0 ? 1 : a;
        long t = pow(a, b / 2);
        return s * t % MOD * t % MOD;
    }

    long div(int i) {
        if (div[i] == 0) {
            long fac = fac(i);
            div[i] = pow(fac, MOD - 2);
        }
        return div[i];
    }

}
