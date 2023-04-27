package Round868.D;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-04-27 22:45
 */
public class Main {
    static Kattio sc;
    public static void main(String[] args) {
        sc = new Kattio();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
        sc.flush();
    }

    private static void solve() {
        int n = sc.nextInt(), k= sc.nextInt();
        int[] x = new int[k];
        for (int i = 0; i < k; i++) {
            x[i] = sc.nextInt();
        }
        int[] c = new int[k];
        for (int i = 0; i < k; i++) {
            c[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        // abc 循环的计数
        int p = 0;
        for (int i = 0; i < k; i++) {
            int len = i > 0 ? x[i] - x[i - 1] : x[0];
            int cnt = i > 0 ? c[i] - c[i - 1] : c[0];
            if (len < cnt) {
                break;
            }
            int y = i > 0 ? cnt : cnt - 3;
            for (int j = 0; j < len - y; j++) {
                sb.append((char) ('a' + p % 3));
                p++;
            }
            // repeat( 'd', )
            for (int j = 0; j < y; j++) {
                sb.append((char) ('d' + i));
            }

        }
        if (sb.length() == n) {
            sc.println("YES");
            sc.println(sb);
        } else {
            sc.println("NO");
        }
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
