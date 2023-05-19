package Round874.E;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-05-20 0:07
 */
public class Main {
    static Kattio sc;
    private static int[] p;
    private static int[] size;
    private static int cnt;

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
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) a[i] = sc.nextInt();
        p = new int[n + 1];
        size = new int[n + 1];
        // 最大值 联通分量的数量
        cnt = n;
        for (int i = 1; i <= n; i++) {
            p[i] = i;
            size[i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            union(i, a[i]);
        }
        // 记录不能进行联合的环数
        int c2 = cnt;
        boolean[] vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            // dfs，若环的大小等于
            if (find(i) == i) {
                for (int j = i; !vis[j]; j = a[j]) {
                    vis[j] = true;
                    if (a[a[j]] == j) {
                        c2--;
                        break;
                    }
                }
            }
        }
        sc.println((c2 + (c2 == cnt ? 0 : 1)) + " " + cnt);
    }
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (size[rootA] > size[rootB]) {
                size[rootA] += size[rootB];
                p[rootB] = rootA;
            } else if (size[rootA] < size[rootB]) {
                size[rootB] += size[rootA];
                p[rootA] = rootB;
            } else {
                size[rootA] += size[rootB];
                p[rootB] = rootA;
            }
            cnt--;
        }
    }

    static int find(int a) {
        if (p[a] != a) p[a] = find(p[a]);
        return p[a];
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
