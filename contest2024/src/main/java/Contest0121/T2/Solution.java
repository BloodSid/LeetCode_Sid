package Contest0121.T2;

/**
 * @author IronSid
 * @since 2024-01-21 10:27
 */
public class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[] f = new int[n];
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                // i -> j, i -> x -> y -> j, i -> y -> x -> j;
                f[min(abs(j - i), 1 + abs(i - x) + abs(j - y), 1 + abs(i - y) + abs(j - x)) - 1]++;
            }
        }
        for (int i = 0; i < f.length; i++) {
            f[i] *= 2;
        }
        return f;
    }

    int abs(int a) {
        return Math.abs(a);
    }

    int min(int... x) {
        int t = x[0];
        for (int i = 1; i < x.length; i++) {
            t = Math.min(t, x[i]);
        }
        return t;
    }
}
