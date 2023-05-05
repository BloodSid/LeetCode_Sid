package Round870.A;

import java.io.*;
import java.util.*;

/**
 * @author IronSid
 * @since 2023-05-05 23:24
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
        int[] l = new int[n];
        for (int i = 0; i < n; i++) l[i] = sc.nextInt();
        for (int guess = 0; guess <= n; guess++) {
            // 假设假话人数为guess的情况下，cnt表示有多少人和假设不符
            int cnt = 0;
            for (int li : l) {
                if (guess < li) cnt++;
            }
            if (cnt == guess) {
                System.out.println(guess);
                return;
            }
        }
        System.out.println(-1);
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