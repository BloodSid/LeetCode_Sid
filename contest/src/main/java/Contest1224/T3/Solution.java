package Contest1224.T3;

/**
 * @author IronSid
 * @since 2022-12-24 23:10
 */
public class Solution {
    public int minimizeSet(long d1, long d2, int c1, int c2) {
        long lcm = d1 * d2 / gcd(d1, d2);
        // 二分
        long l = 2, r = (long) 1e10;
        while (l <= r) {
            long mid = l + r >> 1;
            // 只被 d2 整除的放 a1，只被 d1 整除的放 a2, 被同时整除（公倍数）的舍弃，不被任何整除的用来放 a1 和 a2 的残余
            long r1 = Math.max(0, c1 - (mid / d2 - mid / lcm));
            long r2 = Math.max(0, c2 - (mid / d1 - mid / lcm));
            boolean vaild = mid - mid / d1 - mid / d2 + mid / lcm >= r1 + r2;
            if (vaild) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    long gcd(long a, long b) {
        // gcd(a,b) = gcd(b,a mod b)
        while (b != 0) {
            long t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}
