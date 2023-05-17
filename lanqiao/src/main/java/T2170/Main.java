package T2170;

import java.util.Scanner;

/**
 * @author IronSid
 * @since 2023-05-18 2:15
 */
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();
        sc.nextLine();
        long ans = 0;
        for (int i = 0; i < T; i++) {
            ans += solve();
        }
        if (ans == 0) {
            System.out.println("0B");
            return;
        }
        StringBuilder sb = new StringBuilder();
        int mask = 1023;
        if (ans >> 30 != 0) {
            sb.append(ans >> 30).append("GB");
        }
        if ((ans >> 20 & mask) != 0) {
            sb.append(ans >> 20 & mask).append("MB");
        }
        if ((ans >> 10 & mask) != 0) {
            sb.append(ans >> 10 & mask).append("KB");
        }
        if ((ans & mask) != 0) {
            sb.append(ans & mask).append("B");
        }
        System.out.println(sb);
    }

    private static long solve() {
        String line = sc.nextLine();
        if (line.contains("[]")) {
            // 数组
            int size = line.startsWith("long") ? 8 : 4;
            long len = 0;
            // 等号后的第一个左括号
            int start = line.indexOf('[', line.indexOf('=') + 1);
            int end = line.indexOf(']', start + 1);
            for (; ; ) {
                len += Long.parseLong(line.substring(start + 1, end));
                start = line.indexOf('[', end + 1);
                if (start == -1) break;
                end = line.indexOf(']', start + 1);
            }
            return len * size;
        } else if (line.startsWith("int")) {
            long cnt = 0;
            for (int p = line.indexOf('='); p >= 0; p = line.indexOf('=', p + 1)) {
                cnt++;
            }
            return cnt * 4;
        } else if (line.startsWith("long")) {
            long cnt = 0;
            for (int p = line.indexOf('='); p >= 0; p = line.indexOf('=', p + 1)) {
                cnt++;
            }
            return cnt * 8;
        } else if (line.startsWith("String")) {
            long len = 0;
            int start = line.indexOf('"');
            int end = line.indexOf('"', start + 1);
            for (; ; ) {
                len += end - start - 1;
                start = line.indexOf('"', end + 1);
                if (start == -1) break;
                end = line.indexOf('"', start + 1);
            }
            return len;
        }
        return 0;
    }

}
