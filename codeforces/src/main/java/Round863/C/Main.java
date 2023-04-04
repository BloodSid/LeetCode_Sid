package Round863.C;

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
        int n = sc.nextInt();
        int[] b = new int[n - 1];
        for (int i = 0; i < b.length; i++) {
            b[i] = sc.nextInt();
        }
        int[] a = new int[n];
        a[0] = b[0];
        for (int i = 1; i < n - 1; i++) {
            a[i] = Math.min(b[i], b[i - 1]);
        }
        a[n - 1] = b[n - 2];
        StringBuffer sb = new StringBuffer();
        for (int i : a) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
}