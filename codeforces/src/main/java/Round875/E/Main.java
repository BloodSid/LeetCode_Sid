package Round875.E;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * @author IronSid
 * @since 2023-05-05 23:25
 */
public class Main {
    public static final Random rand = new Random();
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

    public static final int M = 998244353;
    public static final int N = (int) 3e5;
    public static final BigInteger BIM = BigInteger.valueOf(M);

    private static void solve() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        // 差分数组
        int[] diff = new int[n + 2];
        for (int i = 0; i < k; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int nextInt = rand.nextInt();
            // 异或哈希
            diff[l] ^= nextInt;
            diff[r + 1] ^= nextInt;
        }
        // 若不同分段间哈希值相等，视为可以拼接转化成连续的一段
        int t = 0;
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            t ^= diff[i];
            f.merge(t, 1, Integer::sum);
        }
        long ans = 1;
        for (int a : f.values()) {
            // 奇数长度的括号字符串必不平衡
            if (a % 2 == 1) {
                ans = 0;
                break;
            }
            // 段内为卡特兰数。段间以乘法原理计数
            // 卡特兰树数也可以用 H(n)=H(n-1)*(4n-2)/(n+1) 计算
            long s = C(a, a / 2).multiply(BigInteger.valueOf(a / 2 + 1).modInverse(BIM)).mod(BIM).longValueExact();
            ans = ans * s % M;
        }
        sc.println(ans);
    }

    static HashMap<String, BigInteger> C = new HashMap<>();

    static BigInteger C(int n, int k) {
        C.computeIfAbsent(n + " " + k, t ->
                fac(n).multiply(fac(n - k).modInverse(BIM)).multiply(fac(k).modInverse(BIM)).mod(BIM));
        return C.get(n + " " + k);
    }

    static List<Long> fac = new ArrayList<>((int) (N + 10));

    static {
        fac.add(1L);
    }

    static BigInteger fac(int n) {
        for (int i = fac.size(); i <= n; i++) {
            fac.add(fac.get(i - 1) * i % M);
        }
        return BigInteger.valueOf(fac.get(n));
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