package HJ52;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author IronSid
 * @since 2022-02-12 18:35
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a;
        while ((a = br.readLine()) != null) {
            String b = br.readLine();
            int m = a.length();
            int n = b.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i <= n; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                    }
                }
            }
            for (int[] ints : dp) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println(dp[m][n]);
        }
    }

    static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
