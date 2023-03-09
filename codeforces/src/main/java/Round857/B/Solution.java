package Round857.B;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-03-09 18:29
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int cases = 0; cases < N; cases++) {
            int n = sc.nextInt();
            int[] plan = new int[n];
            for (int i = 0; i < n; i++) {
                plan[i] = sc.nextInt();
            }
            int max = 0;
            int known = 0;
            int unknown = 0;
            for (int i = 0; i < n; i++) {
                if (plan[i] == 1) {
                    unknown++;
                } else {
                    known += unknown;
                    unknown = 0;
                }
                max = Math.max(max, unknown + ((known != 0) ? (known / 2 + 1) : 0));
            }
            System.out.println(max);
        }
    }
}
