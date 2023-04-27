package Round868.B;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-04-27 22:44
 */
public class Main {
    static Main.Kattio sc;
    public static void main(String[] args) {
        sc = new Main.Kattio();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
        sc.flush();
    }

    static void solve() {
        int n = sc.nextInt(), k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        if (k == 1) {
            sc.println(0);
            return;
        }
        // 判断每个元素是否和下标同余
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % k != (i + 1) % k) cnt++;
        }
        if (cnt == 2) {
            sc.println(1);
        } else if (cnt == 0) {
            sc.println(0);
        } else {
            sc.println(-1);
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
