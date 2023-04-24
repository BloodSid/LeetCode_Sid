package Round867.A;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-04-24 23:03
 */
public class Main {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
;
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt(), t = sc.nextInt();
        int[] du = new int[n];
        for (int i = 0; i < n; i++) {
            du[i] = sc.nextInt();
        }
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
        int ans = -1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i + du[i] <= t) {
                if (value[i] > max) {
                    max = value[i];
                    ans = i;
                }
            }
        }
        System.out.println(ans != -1 ? ans + 1 : -1);
    }
}
