package Round869.C;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-04-29 22:25
 */
public class Main {
    static Kattio sc;
    private static int[] p;

    public static void main(String[] args) {
        sc = new Kattio();
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            // 依次递减的相邻三个元素造成结果减一
            if (i >= 2 && a[i - 2] >= a[i - 1] && a[i - 1] >= a[i]) {
                p[i + 1] = p[i];
            } else {
                p[i + 1] = p[i] + 1;
            }
        }
        for (int i = 0; i < q; i++) {
            query();
        }
        sc.flush();
    }

    private static void query() {
        int l = sc.nextInt(), r = sc.nextInt();
        if (r - l + 1 <= 2) {
            sc.println(r - l + 1);
            return;
        }
        // 前两个元素肯定不会造成结果减一
        sc.println(p[r] - p[l + 1] + 2);
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
