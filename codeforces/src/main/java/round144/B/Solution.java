package round144.B;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-02-28 23:05
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());
        for (int css = 0; css < cases; css++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            if (a.charAt(0) == b.charAt(0)) {
                System.out.println("yes");
                System.out.println(a.charAt(0) + "*");
            } else if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1)) {
                System.out.println("yes");
                System.out.println("*" + a.charAt(a.length() - 1));
            } else {
                HashSet<String> set = new HashSet<>();
                for (int i = 0; i < a.length() - 1; i++) {
                    set.add(a.substring(i, i + 2));
                }
                boolean isOK = false;
                String sub = "";
                for (int i = 0; i < b.length() - 1; i++) {
                    sub = b.substring(i, i + 2);
                    if (set.contains(sub)) {
                        isOK = true;
                        break;
                    }
                }
                if (isOK) {
                    System.out.println("yes");
                    System.out.println("*" + sub + "*");
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}
