package Round859.D;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-03-19 23:08
 */
public class Solution {
    public static void main(String[] args) {
        Kattio ka = new Kattio();
        int N = ka.nextInt();
        for (int cases = 0; cases < N; cases++) {
            int n = ka.nextInt();
            int q = ka.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ka.nextInt() % 2;
            }
            int[] p = new int[n + 1];
            int t = 0;
            for (int i = 0; i < n; i++) {
                t ^= a[i];
                p[i + 1] = t;
            }
            for (int i = 0; i < q; i++) {
                int l = ka.nextInt();
                int r = ka.nextInt();
                int k = ka.nextInt() % 2;
                if ((p[n] - p[r] + p[l - 1] + k * (r - l + 1) + 2) % 2 == 1) {
                    ka.println("YES");
                } else {
                    ka.println("NO");
                }
            }
        }
        ka.flush();
    }

    public static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // 标准io
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // 文件io
        public Kattio(String input, String output) throws IOException {
            super(output);
            r = new BufferedReader(new FileReader(input));
        }

        // 在没有其它输入时返回null
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
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
