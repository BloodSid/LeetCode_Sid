package Contest0121.T4;

/**
 * @author IronSid
 * @since 2023-01-21 22:32
 */
public class Solution {
    public boolean isReachable(int a, int b) {
        while (a % 2 == 0) {
            a /= 2;
        }
        while (b % 2 == 0) {
            b /= 2;
        }
        return gcd(a, b) == 1;
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
