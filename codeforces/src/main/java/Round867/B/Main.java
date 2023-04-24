package Round867.B;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-04-24 23:11
 */
public class Main {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        if (n == 2) {
            System.out.println(a[0] * a[1]);
            return;
        }
        Arrays.sort(a);
        long max = Long.MIN_VALUE;
        max = Math.max(max, a[0] * a[1]);
        max = Math.max(max, a[n - 1] * a[n - 2]);
        System.out.println(max);
    }
}
