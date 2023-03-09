package Round857.C;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-03-09 19:23
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int cases = 0; cases < N; cases++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(n * m);
            int[][] res = new int[n][m];
            // res[i][j] 由 i j 的 bits 交错构成
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int t = 0;
                    for (int k = 0; i >> k != 0; k++) {
                        if (((i >> k) & 1) == 1) t |= 1 << (2 * k);
                    }
                    for (int k = 0; j >> k != 0; k++) {
                        if (((j >> k) & 1) == 1) t |= 1 << (2 * k + 1);
                    }
                    res[i][j] = t;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sb.append(res[i][j]);
                    if (j != m - 1)
                        sb.append(' ');
                    else
                        sb.append('\n');
                }
            }
            System.out.print(sb);
        }
    }
}
