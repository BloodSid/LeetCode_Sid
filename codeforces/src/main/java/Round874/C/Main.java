package Round874.C;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-05-19 23:05
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
        Integer[] ai = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            ai[i] = i;
        }
        shuffle(ai);
        Arrays.sort(ai, (o1, o2) -> a[o1] - a[o2]);
        int sum = 3;
        int p = 0;
        // 用两个 bit 表示是否可以得到奇数和偶数
        for (int i = 0; i < n; i++) {
            int t = a[ai[i]] & 1;
            int s = 0;
            if (t == 1) {
                // 奇数
                s = p >> 1 | ((p & 1) << 1);
            } else {
                s = p;
            }
            sum &= (1 << t) | s;
            p |= 1 << t;
        }
        if (sum > 0) {
            sc.println("YES");
        } else {
            sc.println("NO");
        }
    }

    static Random random = new Random();
    private static void shuffle(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            swap(a, i, i + random.nextInt(a.length - i));
        }
    }

    private static void swap(Object[] a, int i, int j) {
        Object t = a[i];
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
