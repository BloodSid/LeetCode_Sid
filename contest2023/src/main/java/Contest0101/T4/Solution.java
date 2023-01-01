package Contest0101.T4;

/**
 * @author IronSid
 * @since 2023-01-01 10:36
 */
public class Solution {
    public int[] closestPrimes(int left, int right) {
        Integer last = null;
        int minD = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        for (int i = left; i <= right; i++) {
            if (!isPrime(i)) continue;
            if (last != null && i - last < minD) {
                minD = i - last;
                res = new int[]{last, i};
            }
            if (minD == 2) break;
            last = i;
        }
        return res;
    }

    public boolean isPrime(int N) {
        if (N < 2) return false;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d)
            if (N % d == 0) return false;
        return true;
    }
}
