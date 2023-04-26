package Round859.D;

import java.io.IOException;

/**
 * @author IronSid
 * @since 2023-03-19 23:08
 */
public class Solution {
    static byte[] buf = new byte[(int) 1e7];
    static int cursor = 0;
    static int length = 0;
    static String next() {
        int i;
        for (i = cursor; i < length; i++) {
            if (buf[i] == ' ' || buf[i] == '\r') {
                break;
            }
        }
        String s = new String(buf, cursor, i - cursor);
        if (i < length) {
            // \r\n 跳过两个字节
            cursor = buf[i] == ' ' ? i + 1 : i + 2;
        }
        return s;
    }
    public static void main(String[] args) {
        try {
            length = System.in.read(buf);
            buf[length] = ' ';
            cursor = 0;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int N = Integer.parseInt(next());
        for (int cases = 0; cases < N; cases++) {
            int n = Integer.parseInt(next());
            int q = Integer.parseInt(next());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(next()) % 2;
            }
            int[] p = new int[n + 1];
            int t = 0;
            for (int i = 0; i < n; i++) {
                t += a[i];
                p[i + 1] = t;
            }
            for (int i = 0; i < q; i++) {
                int l = Integer.parseInt(next());
                int r = Integer.parseInt(next());
                int k = Integer.parseInt(next()) % 2;
                if ((p[n] - p[r] + p[l - 1] + k * (r - l + 1) + 2) % 2 == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
