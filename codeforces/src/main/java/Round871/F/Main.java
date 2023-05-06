package Round871.F;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-05-06 23:51
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
        int n = sc.nextInt(), m = sc.nextInt();
        int[] cnt = new int[n];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            cnt[u]++;
            cnt[v]++;
        }
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int i : cnt) {
            f.merge(i, 1, Integer::sum);
        }
        int x = 0, y = 0;
        if (f.size() == 3) {
            for (Map.Entry<Integer, Integer> e : f.entrySet()) {
                if (e.getValue() == 1) {
                    x = e.getKey();
                } else if (e.getKey() != 1) {
                    y = e.getKey() - 1;
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> e : f.entrySet()) {
                if (e.getKey() != 1) {
                    x = e.getKey();
                    y = e.getKey() - 1;
                }
            }
        }
        sc.println(x + " " + y);
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
