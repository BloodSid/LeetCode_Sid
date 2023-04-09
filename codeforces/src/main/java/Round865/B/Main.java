package Round865.B;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-04-09 22:52
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
        int[][] res = new int[2][n];
        res[0][0] = 2 * n;
        for (int i = n - 1, v = 2 * n - 1; i >= 0; i -= 2, v -= 2) {
            res[1][i] = v;
        }
        for (int i = 0, v = 1; i < n; i += 2, v += 2) {
            res[1][i] = v;
        }
        for (int i = 1; i < n; i++) {
            res[0][i] = res[1][i - 1] + 1;
        }
        for (int i = 0; i < 2; i++) {
            StringBuilder sb = new StringBuilder();
            for (int i1 = 0; i1 < res[i].length; i1++) {
                sb.append(res[i][i1]).append(' ');
            }
            System.out.println(sb);
        }
    }
}
