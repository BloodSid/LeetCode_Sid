package Contest1030.T3;

/**
 * @author IronSid
 * @since 2022-10-30 10:29
 */
public class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long mod = 1;
        for (long t = n; ; mod *= 10) {
            t = t + (mod - t % mod) % mod;
            int sum = 0;
            for (long s = t; s > 0; s /= 10) {
                sum += s % 10;
            }
            if (sum <= target) return t - n;
        }
    }
}
