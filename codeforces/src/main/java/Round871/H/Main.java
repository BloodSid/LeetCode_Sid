package Round871.H;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-05-06 23:01
 */
public class Main {
    public static final int MOD = (int) (1e9 + 7);
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
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        // dp[i] 与运算为 i 的子序列个数
        long[] dp = new long[64];
        for (int i : a) {
            for (int j = 0; j < 64; j++) {
                dp[i & j] = (dp[i & j] + dp[j]) % MOD;
            }
            dp[i]++;
        }
        long res = 0;
        for (int i = 0; i < 64; i++) {
            if (Integer.bitCount(i) == k) {
                res += dp[i];
            }
        }
        System.out.println(res % MOD);
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
