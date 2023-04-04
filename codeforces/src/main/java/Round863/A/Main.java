package Round863.A;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    static void solve() {
        int n = sc.nextInt();
        int d = sc.nextInt();
        char[] s = sc.next().toCharArray();
        StringBuffer sb = new StringBuffer();
        // 在第一处 s[i] < d 的地方插入
        int i = 0;
        for (; i < n; i++) {
            if (s[i] - '0' < d) {
                break;
            }
            sb.append(s[i]);
        }
        sb.append(d);
        sb.append(s, i, n - i);
        System.out.println(sb);
    }
}
