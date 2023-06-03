package Round876.C;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        if (a[n - 1] == 1) {
            sc.println("NO");
        } else {
            sc.println("YES");
            // 从后向前构造，连续的0用连续的p=0组成，连续的1与之后的一个0组成的一段用连续的p=0和一个p=t组成
            List<Integer> p = new ArrayList<>();
            for (int i = n - 1, t = 1; i >= 0; i--) {
                if (i == 0 || a[i - 1] != a[i]) {
                    if (a[i] == 0) {
                        // 扣减1个0，以供下一段连续的1用
                        for (int i1 = 0; i1 < t - 1; i1++) {
                            p.add(0);
                        }
                        // 不存在下一段连续的1
                        if (i == 0) p.add(0);
                    } else {
                        for (int i1 = 0; i1 < t; i1++) {
                            p.add(0);
                        }
                        p.add(t);
                    }
                    t = 1;
                } else {
                    t++;
                }
            }
            StringBuilder sb = new StringBuilder();
            p.forEach(o -> sb.append(o).append(' '));
            sc.println(sb);
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