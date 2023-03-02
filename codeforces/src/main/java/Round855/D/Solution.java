package Round855.D;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-03-03 0:01
 */
public class Solution {

    public static final int MOD = (int) (1e9 + 7);
    public static final int B = 31;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int cases = 0; cases < n; cases++) {
            sc.nextLine();
            String s = sc.nextLine();
            char[] ch = s.toCharArray();
            long[] head = new long[s.length()];
            long[] tail = new long[s.length()];
            long t = 0;
            for (int i = 0; i < ch.length; i++) {
                t = (t * B + ch[i]) % MOD;
                head[i] = t;
            }
            t = 0;
            long v = 1;
            for (int i = ch.length - 1; i >= 0; i--) {
                t = (t + ch[i] * v) % MOD;
                tail[i] = t;
                v = v * B % MOD;
            }
            v = 1;
            for (int i = ch.length - 3; i >= 0; i--) {
                head[i] = head[i] * v % MOD;
                v = v * B % MOD;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < s.length() - 1; i++) {
                long left = i != 0 ? head[i - 1] : 0;
                long right = i + 2 != s.length() ? tail[i + 2] : 0;
                set.add((int) ((left + right) % MOD));
            }
            System.out.println(set.size());
        }
    }
}
