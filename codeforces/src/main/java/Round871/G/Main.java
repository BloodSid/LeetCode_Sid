package Round871.G;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-05-06 23:51
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
        long n = sc.nextInt();
        long l = 1, r = 2023;
        while (l <= r) {
            long mid = l + r >> 1;
            if (mid * (mid + 1) / 2 < n) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // 当前行取 【j1， j2】 上的元素
        long j1 = n - (r * (r + 1) / 2 + 1);
        long j2 = j1;
        long sum = 0;
        for (long i = l; i >= 1; i--) {
            // 这一行的第一个元素和最后一个元素
            long start = i * (i - 1) / 2 + 1;
            long k1 = start + Math.max(0, j1), k2 = Math.min(i - 1, j2) + start;
            sum += k2 * (k2 + 1) * (2 * k2 + 1) / 6 - (k1 - 1) * k1 * (2 * k1 - 1) / 6;
            j1--;
        }
        System.out.println(sum);
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
