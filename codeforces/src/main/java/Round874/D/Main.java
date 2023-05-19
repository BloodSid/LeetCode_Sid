package Round874.D;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-05-19 23:30
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
        int[] a = new int[n];
        int pn = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] == n) pn = i;
        }
        // 若 n 在 a[0] 那么无法通过操作把它放在res[0],则找 n-1;
        if (pn == 0) {
            for (int i = 0; i < n; i++) {
                if (a[i] == n- 1) pn = i;
            }
        }
        int[] res = new int[n];
        if (pn == n - 1) {
            // 若 pn 是最后一个元素，枚举前缀段, 把a[pn:]作为中间段，
            for (int l = n - 1; l >= 0; l--) {
                int[] copy = a.clone();
                reverse(copy, l, n - 1);
                swapFix(copy, l, n - 1);
                res = greater(res, copy);
            }
        }
        // 把 a[pn:] 作为后缀段，枚举
        for (int l = 0; l <= pn - 1; l++) {
            int[] copy = a.clone();
            reverse(copy, l, pn - 1);
            swapFix(copy, l, pn - 1);
            res = greater(res, copy);

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(res[i]).append(' ');
        }
        sc.println(sb);
    }

    static int[] greater(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) return a;
            else if (a[i] < b[i]) return b;
        }
        return a;
    }

    static void swapFix(int[] a, int l, int r) {
        int[] c = a.clone();
        int ai = 0;
        for (int i = r + 1; i < a.length; i++) {
            a[ai++] = c[i];
        }
        for (int i = l; i <= r; i++) {
            a[ai++] = c[i];
        }
        for (int i = 0; i < l; i++) {
            a[ai++] = c[i];
        }
    }

    static void reverse(int[] a, int i, int j) {
        for (; i < j; i++, j--) {
            swap(a, i, j);
        }
    }

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
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
