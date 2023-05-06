package Round871.D;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-05-06 23:29
 */
public class Main {
    static Kattio sc;
    public static void main(String[] args) {
        // 通用模板
        sc = new Kattio();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve();
        }
        sc.flush();
    }

    private static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (m > n) {
            sc.println("NO");
            return;
        } else if (m == n) {
            sc.println("YES");
            return;
        }
        int k = 0;
        for (; n % 3 == 0; ) {
            n /= 3;
            k++;
            if (m % n == 0) {
                // 2的整数次幂
                if (Integer.bitCount(m / n) == 1) {
                    int t = Integer.numberOfTrailingZeros(m / n);
                    if (t <= k) {
                        sc.println("YES");
                        return;
                    }
                }
                break;
            }
        }
        sc.println("NO");
    }

    public static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // 标准 IO
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // 用字符串做输入，标准输出
        public Kattio(String bytes) {
            super(System.out);
            r = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes.getBytes())));
        }

        // 文件 IO
        public Kattio(String intput, String output) throws IOException {
            super(output);
            r = new BufferedReader(new FileReader(intput));
        }

        // 在没有其他输入时返回 null
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
