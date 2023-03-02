package Round855.B;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-03-02 23:14
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            sc.next();
            int k = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            int[] f = new int[128];
            for (char c : s.toCharArray()) {
                f[c]++;
            }
            int ans = 0;
            for (char c = 'a'; c <= 'z'; c++) {
                int min = Math.min(f[c], f[c - 32]);
                ans += min;
                f[c] -= min;
                f[c - 32] -= min;
            }
            int remain = 0;
            for (int v : f) {
                remain += v / 2;
            }
            ans += Math.min(remain, k);
            System.out.println(ans);
        }
    }
}
