package Round867.D;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-04-24 23:24
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
        int[] a = new int[n];
        // 奇数除了1其余的无法构成结果
        if (n % 2 == 1) {
            if (n == 1) System.out.println(1);
            else System.out.println(-1);
            return;
        }
        // 第一个只能是n
        a[0] = n;
        for (int i = 1, t = n - 1; i < n; i++) {
            if (i % 2 == 1) {
                a[i] = t - a[i - 1] % n;
            } else {
                a[i] = n + 1 - a[i - 1];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(a[i]).append(" ");
        }
        System.out.println(sb);
    }
}
