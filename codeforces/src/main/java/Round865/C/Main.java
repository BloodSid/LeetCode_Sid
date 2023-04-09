package Round865.C;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-04-09 22:53
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            if(solve()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    static boolean solve(){
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        if (n % 2 == 1) return true;
        long[] sum = new long[2];
        // 每次操作奇数位置上的元素和与偶数位置上的元素和的差保持不变
        for (int i = 0; i < n; i++) {
            sum[i % 2] += a[i];
        }
        return sum[0] <= sum[1];
    }
}
