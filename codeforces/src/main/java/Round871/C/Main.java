package Round871.C;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-05-06 23:23
 */
public class Main {
    public static final int INF = Integer.MAX_VALUE;
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
        int min = INF;
        int mn1 = INF, mn2 = INF;
        for (int i = 0; i < n; i++) {
            int time = sc.nextInt();
            String s = sc.next();
            if (s.equals("11")) {
                min = Math.min(min, time);
            } else if (s.equals("10")) {
                mn1 = Math.min(mn1, time);
            } else if (s.equals("01")) {
                mn2 = Math.min(mn2, time);
            }
        }
        if (mn1 != INF && mn2 != INF) {
            min = Math.min(min, mn1 + mn2);
        }
        sc.println(min != INF ? min : -1);
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
