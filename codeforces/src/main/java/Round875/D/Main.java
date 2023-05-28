package Round875.D;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-05-05 23:25
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
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();
        int minBi = n + 1, maxBi = 0;
        HashMap<String, Integer> map = new HashMap<>();
        long ans = 0;
        for (int j = 0; j < n; j++) {
            // 计算 ai 的范围
            int low = Math.max(1, (b[j] + minBi + a[j] - 1) / a[j]), high = Math.min(n, (b[j] + maxBi) / a[j]);
            for (int ai = low; ai <= high; ai++) {
                int bi = ai * a[j] - b[j];
                ans += map.getOrDefault(ai + " " + bi, 0);
            }
            map.merge(a[j] + " " + b[j], 1, Integer::sum);
            maxBi = Math.max(maxBi, b[j]);
            minBi = Math.min(minBi, b[j]);
        }
        sc.println(ans);
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