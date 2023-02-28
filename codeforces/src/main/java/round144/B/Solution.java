package round144.B;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-02-28 23:05
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] s = new String[51][51];
        for (int i = 0; i < 51; i++) {
            s[i][0] = "*";
            s[0][i] = "*";
        }
        s[0][0] = "";
        int[][] dp = new int[51][51];
        int cases = Integer.parseInt(sc.nextLine());
        for (int css = 0; css < cases; css++) {
            char[] a = sc.nextLine().toCharArray();
            char[] b = sc.nextLine().toCharArray();
            // LCS
            int m = a.length;
            int n = b.length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i] == b[j]) {
                        dp[i+1][j+1] = dp[i][j] + 1;
                        s[i+1][j+1] = s[i][j] + a[i];
                    } else {
                        dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                        if (dp[i+1][j] > dp[i][j+1]) {
                            s[i+1][j+1] = s[i+1][j];
                        } else if (dp[i+1][j] < dp[i][j+1]) {
                            s[i+1][j+1] = s[i][j+1];
                        } else {
                            // 两个状态 LCS 相等，优先选结尾为 * 的
                            if (s[i+1][j].endsWith("*")) {
                                s[i+1][j+1] = s[i+1][j];
                            } else {
                                s[i+1][j+1] = s[i][j+1];
                            }
                        }
                        // 如果没 * 加上 *
                        if (!s[i+1][j+1].endsWith("*")) {
                            s[i+1][j+1] += "*";
                        }
                    }
                }
            }
            // LCS 大小必须大于等于 s[m][n] 的一半
            if (dp[m][n] >= (s[m][n].length() + 1 )/ 2) {
                System.out.println("yes");
                System.out.println(s[m][n]);
            } else {
                System.out.println("no");
            }
        }
    }
}
