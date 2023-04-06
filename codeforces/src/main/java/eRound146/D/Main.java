package eRound146.D;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] f = new long[n];
            long[] d = new long[n];
            for (int i1 = 0; i1 < f.length; i1++) f[i1] = sc.nextLong();
            for (int i1 = 0; i1 < d.length; i1++) d[i1] = sc.nextLong();
            System.out.println(solve(n, k, f, d));
        }
    }

    static int solve(int n, int k, long[] rate, long[] damage) {
        long[] p = new long[n];
        for (int i = 0; i < n; i++) {
            p[i] = rate[i] * damage[i];
        }
        Arrays.sort(p);
        // 求滑窗的最大长度
        int maxLen = 0;
        for (int i = 0, j = 0; j < n; ) {
            j++;
            while (i < j && p[j - 1] - p[i] > k) {
                i++;
            }
            maxLen = Math.max(maxLen, j - i);
        }
        return n - maxLen;
    }


}
