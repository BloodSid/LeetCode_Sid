package eRound146.E;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static long[] a;


    public static void main(String[] args) {
        int n = sc.nextInt();
        a = new long[n - 1];
        for (int i1 = 0; i1 < n - 1; i1++) {
            a[i1] = sc.nextLong();
        }
        // 对于单次查询，可以用动态规划，选择若干不相邻也不在a的端点的边不走，剩下的边每条通过两次，即为最小成本
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) System.out.println(query(sc.nextInt() - 1, sc.nextLong()));
    }


    private static long query(int k, long x) {
        a[k] = x;
        return 0;
    }
}
