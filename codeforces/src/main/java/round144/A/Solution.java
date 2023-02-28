package round144.A;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-02-28 22:50
 */
public class Solution {
    public static void main(String[] args) {
        String f = "FBFFBFFB";
        f = f + f + f;
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cases; i++) {
            sc.nextLine();
            String s = sc.nextLine();
            if (f.contains(s)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
