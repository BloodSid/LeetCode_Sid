package Round863.D;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long[] f = new long[50];
    public static void main(String[] args) {
        f[0] = f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
        // 切割前的矩形的两个对角
        long x1 = 0, y1 = 0;
        long x2 = f[n], y2 = f[n + 1];
        long e = 0;
        while (true) {
            e = Math.min(x2 - x1, y2 - y1);
            if (e == 1) {
                break;
            }
            // 竖切
            if (x2 - x1 == e) {
                if (y > y1 + e) {
                    y1 += e;
                } else if (y <= y2 - e) {
                    y2 -= e;
                } else {
                    break;
                }
            } else {
                if (x > x1 + e) {
                    x1 += e;
                } else if (x <= x2 - e) {
                    x2 -= e;
                } else {
                    break;
                }
            }
        }
        if (e == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
