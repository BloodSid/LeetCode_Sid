package Round859.B;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-03-19 22:32
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        for (int i = 0; i < row; i++) {
            int n = sc.nextInt();
            int[] candy = new int[n];
            for (int i1 = 0; i1 < n; i1++) {
                candy[i1] = sc.nextInt();
            }
            int even = 0;
            int odd = 0;
            for (int c : candy) {
                if (c % 2 == 1) {
                    odd += c;
                } else {
                    even += c;
                }
            }
            if (even > odd) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
