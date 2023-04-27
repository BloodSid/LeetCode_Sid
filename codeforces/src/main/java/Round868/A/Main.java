package Round868.A;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-04-27 22:42
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

    static void solve() {
        int n = sc.nextInt(), k = sc.nextInt();
        int a = 0, b = n;
        boolean flag = false;
        for (; a <= b; a++, b--) {
            if (a * (a - 1) / 2 + b * (b - 1) / 2 == k) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            sc.println("NO");
            return;
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < a; i++) {
            ans[i] = 1;
        }
        sc.println("YES");
        for (int i = 0; i < n; i++) {
            sc.print(ans[i]);
            if (i == n - 1) sc.println();
            else sc.print(' ');
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
