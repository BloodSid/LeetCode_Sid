package T1563;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2023-05-18 23:55
 */
public class Main {

    private static long[] f;

    public static void main(String[] args) {
        int n = 2021;
        f = new long[n + 1];
        Arrays.fill(f, -1);
        f[0] = 0;
        System.out.println(f(n));
    }

    private static long f(int n) {
        if (f[n] != -1) return f[n];
        long min = Long.MAX_VALUE;
        for (int l = 0, r = n - 1; l < n; l++, r--) {
            min = Math.min(min, 1 + 2 * f(l) + 3 * f(r) + (long) l * l * r);
        }
        f[n] = min;
        return f[n];
    }
}

