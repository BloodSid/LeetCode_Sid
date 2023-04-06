package Round863.G;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static final int MOD = (int) (1e9 + 7);
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt(), k = sc.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < c.length; i++) {
            c[i] = sc.nextInt();
        }
        if (k == 1) {
            System.out.println(1);
            return;
        }
        int m = n / k * k;
        // f(i, j) 颜色为i，长度为j的符合要求的子序列
        long[][] f = new long[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            f[i][0] = 1;
        }
        int maxP = 0;
        for (int t = 0; t < n; t++) {
            int cur = c[t];
            for (int j = m; j >= 2; j--) {
                if (j % k == 1) {
                    long sum = 0;
                    for (int i = 1; i <= n; i++) {
                        sum += f[i][j - 1];
                    }
                    f[cur][j] = (f[cur][j] + sum) % MOD;
                } else {
                    f[cur][j] = (f[cur][j] + f[cur][j - 1]) % MOD;
                }
                if (j % k == 0 && f[cur][j] > 0) maxP = Math.max(maxP, j);
            }
            f[cur][1]++;
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += f[i][maxP];
        }
        if (maxP == 0) {
            System.out.println(1);
        } else {
            System.out.println(res % MOD);
        }
    }
}

class Test {
    public static void main(String[] args) throws IOException {
        String input = "1\n" +
                "6 1\n" +
                "3 3 3 2 6 5";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        Main.main(null);

    }
}
