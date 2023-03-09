package Round857.A;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-03-09 17:59
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int cases = 0; cases < N; cases++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int like = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    like++;
                }
            }
            int max = 0;
            for (int i = 0, t = like; i < n; i++) {
                if (t > 0) {
                    max++;
                    t--;
                } else {
                    max--;
                }
                System.out.print(max);
                System.out.print(' ');
            }
            System.out.println();
            int min = 0;
            for (int i = 0, t = n - like; i < n; i++) {
                if (t > 0 && min > 0) {
                    min--;
                    t--;
                } else {
                    min++;
                }
                System.out.print(min);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
