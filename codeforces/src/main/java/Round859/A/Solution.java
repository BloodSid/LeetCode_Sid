package Round859.A;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-03-19 22:33
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a + b == c) {
                System.out.println("+");
            } else {
                System.out.println("-");
            }
        }
    }
}
