package ERound150.C;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
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
    static int[] v = new int[128];
    static {
        int t = 1;
        for (char c = 'A'; c <= 'E'; c++) {
            v[c] = t;
            t = t * 10;
        }
    }

    private static void solve() {
        char[] c = sc.next().toCharArray();
        int n = c.length;
        int sum = 0;
        char max = 0;
        char[] sufMax = new char[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sum += max > c[i] ? -v[c[i]] : v[c[i]];
            if (c[i] > max) max = c[i];
            sufMax[i] = max;
        }
        int maxD = 0;
        // 栈内元素统计
        int[] p = new int[128];
        int[] w = new int[128];
        Deque<Character> stack = new ArrayDeque<>();
        // 单调栈
        for (int i = 0; i < n; i++) {
            // 计算c[i] 的不同取值对应的贡献
            int t = 0;
            for (char d = 'A'; d <= 'E'; d++) {
                w[d] = (sufMax[i + 1] > d ? -v[d] : v[d]) + t;
                t -= 2 * p[d] * v[d];
            }
            // 用不同的c[i]的贡献更新maxD
            for (char d = 'A'; d <= 'E'; d++) {
                maxD = Math.max(maxD, w[d] - w[c[i]]);
            }
            while (!stack.isEmpty() && stack.peek() < c[i]) {
                p[stack.pop()]--;
            }
            p[c[i]]++;
            stack.push(c[i]);
        }
        sc.println(sum + maxD);
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