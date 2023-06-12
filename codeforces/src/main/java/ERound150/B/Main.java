package ERound150.B;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-05-05 23:25
 */
public class Main {
    static Kattio sc;
    public static void main(String[] args) {
        sc = new Kattio();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve();
        }
        sc.flush();
    }

    private static void solve() {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i =0; i < n ; i++) a[i] = sc.nextInt();
        // 记录是否出现过逆序
        boolean rev = false;
        for (int i = 0, first = 0, last = 0; i < n; i++) {
            boolean add = false;
            if (i == 0) {
                add = true;
                first = a[i];
            } else {
                if (rev) {
                    // 若出现过逆序，则ai必须大于等于last小于等于first才能插入
                    add = a[i] >= last && a[i] <= first;
                } else {
                    // 若未出现过逆序，则ai必须大于等于last或小于等于first才能插入
                    add = a[i] >= last || a[i] <= first;
                }
            }
            if (add) {
                rev |= a[i] < last;
                last = a[i];
            }
            sc.print(add ? 1 : 0);
        }
        sc.println();
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