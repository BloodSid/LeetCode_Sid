package Round868.C;

import java.io.*;
import java.util.HashMap;
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

    private static void solve() {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int num : a) {
            for (int i = 2; i * i <= num; i++) {
                while (num % i == 0) {
                    num /= i;
                    f.merge(i, 1, Integer::sum);
                }
            }
            if (num != 1) {
                f.merge(num, 1, Integer::sum);
            }
        }
        // 同一种质因子两两组成一个b，剩余的质因子中，至少三个不同的组成一个b
        int res = 0;
        int remain = 0;
        for (Integer cnt : f.values()) {
            res += cnt / 2;
            remain += cnt % 2;
        }
        res += remain / 3;
        sc.println(res);
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
