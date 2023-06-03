package Round876.B;

import java.io.*;
import java.util.*;

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
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // 按a顺序，b逆序排列
        list.sort((o1, o2) -> a[o1] != a[o2] ? a[o1] - a[o2] : b[o2] - b[o1]);
        long res = 0;
        // 打开且没破的灯
        HashSet<Integer> on = new HashSet<>();
        // i 指向第一盏没破的灯
        for (int i = 0, j = 0; j < n && i < n;) {
            // 打开这盏灯
            j = Math.max(i, j);
            res += b[list.get(j)];
            on.add(list.get(j));
            j++;
            // 挪动 i
            int x = on.size();
            while (i < n && a[list.get(i)] <= x) {
                on.remove(list.get(i));
                i++;
            }
        }
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