package Contest0414.T3;

/**
 * @author IronSid
 * @since 2024-04-14 10:27
 */
public class Solution {

    public static final long MAX_COIN = 25L;
    private long[] lcm;
    private int m;

    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        m = (1 << n);
        // lcd(i) 表示 bits(i) 子集对应的LCM
        lcm = new long[m];
        lcm[0] = 1;
        for (int i = 1; i < m; i++) {
            lcm[i] = lcm(lcm[i & i - 1], coins[Integer.numberOfTrailingZeros(i)]);
        }
        // 二分法计算结果
        long l = k, r = MAX_COIN * k;
        while (l <= r) {
            long mid = l + r >> 1;
            if (check(mid) >= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 【1，t】包含多少在是coin整数倍的数
    long check(long t) {
        long res = 0;
        for (int i = 1; i < m; i++) {
            int cnt = Integer.bitCount(i);
            if (cnt % 2 == 1) {
                res += t / lcm[i];
            } else {
                res -= t / lcm[i];
            }
        }
        return res;
    }

    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
