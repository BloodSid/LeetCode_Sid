package Contest0511.T4;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2024-05-11 21:53
 */
public class Solution {
    public int[] findProductsOfElements(long[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < queries.length; i++) {
            long from = queries[i][0], to = queries[i][1], mod = queries[i][2];
            long cnt = p(to + 1) - p(from);
            res[i] = (int) pow(2, cnt, mod);
        }
        return res;
    }

    // bignum 的前x个元素之乘积为 2 ^ p(x)
    long p(long x) {
        // 二分搜索第 x 个元素是哪个正整数的“强数组”
        long l = 1, r= (long) 1e15;
        while (l <= r) {
            long mid = l + r >> 1;
            long[] f = q(mid);
            long cnt = Arrays.stream(f).sum();
            if (cnt >= x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // [1,l) 的贡献
        long[] f = q(l - 1);
        long res = 0;
        for (int i = 0; i < 64; i++) {
            res += i * f[i];
        }
        // l 的贡献
        long t = x - Arrays.stream(f).sum();
        for (int i = 0; i < t; i++) {
            long lowbit = l & -l;
            res += Long.numberOfTrailingZeros(lowbit);
            l -= lowbit;
        }
        return res;
    }

    // [1,x] 的强数组的频次
    long[] q(long x) {
        long[] res = new long[64];
        for (int i = 0; i < 60; i++) {
            long m = 1L << (i + 1);
            long p = (x + 1) / m;
            long q = (x + 1) % m;
            res[i] = p * (1L << i) + Math.max(0, q - (1L << i));
        }
        return res;
    }

    long pow(long a, long b, long mod) {
        // 注意模1的情况
        if (mod == 1) return 0;
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = a * a % mod;
            b >>= 1;
        }
        // 对于模1的情况，也可以返回 res % mod
        return res;
    }
}
