package Round863.B;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt(), x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
        x1 = Math.min(x1, n + 1 - x1);
        y1 = Math.min(y1, n + 1 - y1);
        x2 = Math.min(x2, n + 1 - x2);
        y2 = Math.min(y2, n + 1 - y2);
        System.out.println(Math.abs(Math.min(x1, y1) - Math.min(x2, y2)));
    }
}
