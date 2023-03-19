package Round859.C;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-03-19 22:33
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int cases = 0; cases < N; cases++) {
            int n = sc.nextInt();
            String s = sc.next();
            char[] c = s.toCharArray();
            int[] idx = new int[128];
            Arrays.fill(idx, -1);
            boolean flag = true;
            // 验证同一个字母的下标是否对2同余
            for (int i = 0; i < c.length; i++) {
                if (idx[c[i]] == -1) {
                    idx[c[i]] = i % 2;
                } else {
                    if (idx[c[i]] != i % 2) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
