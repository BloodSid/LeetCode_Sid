package T2117;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        int[] p = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            long t = a[i];
            while (t != 1) {
                p[i]++;
                t = sqrt((t / 2) + 1);
            }
            max = Math.max(max, p[i]);
        }
        int ans = 0;
        for (int i = max; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                if (p[j] != i) continue;
                if (j < n - 1 && a[j] == a[j + 1]) {

                } else {
                    ans++;
                }
                p[j]--;
                a[j] = sqrt(a[j] / 2 + 1);
            }
        }
        System.out.println(ans);
    }

    static long sqrt(long n) {
        if (n == 1) return 1;
        long l = 1, r = n / 2;
        while (l <= r) {
            long mid = l + r >> 1;
            if (mid > n / mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
