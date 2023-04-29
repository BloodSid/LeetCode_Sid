package Round869.B;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-04-29 22:24
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
        int n = sc.nextInt();
        if (n == 1) {
            sc.println(1);
            return;
        }
        if (n % 2 == 1) {
            sc.println(-1);
            return;
        }
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = (i ^ 1) + 1;
        }
        String s = Arrays.toString(d);
        sc.println(s.substring(1, s.length() - 1).replaceAll(",", ""));
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
