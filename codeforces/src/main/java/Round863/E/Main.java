package Round863.E;

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
        long k = sc.nextLong();
        // 把十进制转化成九进制
        char[] c = Long.toString(k, 9).toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= '4') c[i]++;
        }
        System.out.println(c);
    }
}
