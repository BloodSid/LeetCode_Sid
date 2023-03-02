package Round855.D;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-03-03 0:01
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int cases = 0; cases < n; cases++) {
            sc.nextLine();
            String s = sc.nextLine();
            char[] ch = s.toCharArray();
            // 删除字符串中的连续两个字符，一共有 n - 1 中删法
            int ans = ch.length - 1;
            for (int i = 2; i < ch.length; i++) {
                // 对于字符串中的片段“xyx”，删除前两个或者删除后两个的结果都是 “x"，而片段之外的部分又一样，
                // 所以遇每次 ch[i - 2] == ch[i] 都会使得结果少1
                if (ch[i - 2] == ch[i]) ans--;
            }
            System.out.println(ans);
        }
    }
}
