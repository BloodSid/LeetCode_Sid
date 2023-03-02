package Round855.A;

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
            sc.nextLine();
            String s = sc.nextLine();
            boolean isMeow = true;
            s = s.toLowerCase();
            char pre = 0;
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (pre != c) {
                    sb.append(c);
                }
                pre = c;
            }
            isMeow = sb.toString().equals("meow");
            if (isMeow) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
