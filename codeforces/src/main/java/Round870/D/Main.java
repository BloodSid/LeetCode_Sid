package Round870.D;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author IronSid
 * @since 2023-05-05 23:56
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
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        // 左边元素，比较 b[i] + i
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> b[o2] + o2 - b[o1] - o1);
        // 右边元素，比较 b[i] - i
        PriorityQueue<Integer> right = new PriorityQueue<>((o1, o2) -> b[o2] - o2 - b[o1] + o1);
        for (int i = 2; i < n; i++) right.offer(i);
        int max = 0;
        // 枚举中间元素
        for (int i = 1; i < n - 1; i++) {
            left.offer(i - 1);
            // 对右侧元素怠惰删除
            while (!right.isEmpty() && right.peek() < i + 1) right.poll();
            int l = left.peek();
            int r = right.peek();
            max = Math.max(max, b[l] + b[r] + b[i] - (r - l));
        }
        System.out.println(max);
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
