package Round865.D;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-04-09 23:59
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    static void solve(){
        int n = sc.nextInt();
        if (n == 2) {
            System.out.println("! 1 2 2 1");
            sc.nextInt();
            return;
        }
        int[][] ans = new int[2][n];
        // 1. 组成链表
        int[] x;
        if (n % 2 == 0) {
            x = new int[]{n - 1, n + 1};
        } else {
            x = new int[]{n, n + 2};
        }
        for (int xi : x) {
            q1(xi);
        }
        // pi 的下标
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        int[] d = new int[n];
        int pos = 0;
        // 2. 计算所有点到p0的距离, 并根据距离排序
        for (int i = 1; i < n; i++) {
            d[i] = q2(0, i);
            if (d[i] == 1) {
                pos = i;
            }
        }
        // 计算所有点和pos是否在一侧，若不在一侧则d改为负数
        for (int i = 1; i < n; i++) {
            if (i == pos) continue;
            int q = q2(pos, i);
            if (d[i] + 1 == q) d[i] = -d[i];
        }
        // 根据 d 对 idx 进行排序，p(idx[i]) 在链表上排第i个
        Arrays.sort(idx, ((o1, o2) -> d[o1] - d[o2]));
        // 3. 求出链表上的元素依次是多少
        int[] chain = new int[n];
        for (int i = 0, t = n; i < n; i++) {
            chain[i] = t;
            int sum = x[(i + 1) % 2];
            t = sum - t;
        }
        // 4. 把链表上的元素对应到p, 由于第2步中确认的p的顺序只是相对顺序，所以顺向和逆向的链表都有可能是结果
        for (int i = 0; i < n; i++) {
            ans[0][idx[i]] = chain[i];
            ans[1][idx[i]] = chain[n - 1 - i];
        }
        StringBuilder sb = new StringBuilder("!");
        for (int i = 0; i < 2 * n; i++) {
            sb.append(" ").append(ans[i / n][i % n]);
        }
        System.out.println(sb);
        System.out.flush();
        sc.nextInt();
    }

    static void q1(int x) {
        System.out.println("+ " + x);
        System.out.flush();
        sc.nextInt();
    }

    static int q2(int i, int j) {
        i++;
        j++;
        System.out.println("? " + i + " " + j);
        System.out.flush();
        return sc.nextInt();
    }
}
