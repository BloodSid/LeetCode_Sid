package Round867.C;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-04-24 23:13
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
        long n = sc.nextInt();
        long res = 4 * n + 1 + n * (n - 1) / 2 + (n - 1) * (n - 2) / 2;
        System.out.println(res);
    }
}
