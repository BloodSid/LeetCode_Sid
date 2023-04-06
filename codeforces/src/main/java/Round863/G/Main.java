package Round863.G;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static final int MOD = (int) (1e9 + 7);
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt(), k = sc.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < c.length; i++) {
            c[i] = sc.nextInt();
        }
        if (k == 1) {
            System.out.println(1);
            return;
        }
        int m = n / k * k;
        // f(i, j) 颜色为i，长度为j的符合要求的子序列
        long[][] f = new long[n + 1][m + 1];
        // maxP 结尾颜色为j的path的最大长度
        int[] max = new int[n + 1];
        int maxP = 0;
        // sum[j] 长度为j的子序列
        long[] sum = new long[m + 1];
        for (int i = 1; i <= n; i++) {
            f[i][0] = 1;
        }
        sum[0] = 1;
        for (int t = 0; t < n; t++) {
            int cur = c[t];
            for (int j = Math.min(maxP + 1, m); j >= 2; j--) {
                if (j % k == 1) {
                    f[cur][j] = (f[cur][j] + sum[j - 1]) % MOD;
                    sum[j] = (sum[j] + sum[j - 1]) % MOD;
                } else {
                    f[cur][j] = (f[cur][j] + f[cur][j - 1]) % MOD;
                    sum[j] = (sum[j] + f[cur][j - 1]) % MOD;
                }
            }
            // 更新p的最大长度
            max[cur] = Math.max(max[cur], maxP - maxP % k) + 1;
            maxP = Math.max(maxP, max[cur]);
            f[cur][1]++;
            sum[1]++;
        }
        if (maxP == 0) {
            System.out.println(1);
        } else {
            System.out.println(sum[maxP - maxP % k] % MOD);
        }
    }
}

class Test {
    public static void main(String[] args) throws IOException {
        StringBuilder sb  = new StringBuilder();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        int k = 50;
        int m = (int) (1e9+7);
        int rem = m;
        int color = 1;
        for (int n = k + 10; n >= k; n--) {
            int i = 0;
            while ((i + 1) * C(n, k) <= rem) {
                i += 1;
            }
            if (i != 0) {
                rem -= i * C(n, k);
                for (int i1 = 0; i1 < i; i1++) {
                    for (int i2 = 0; i2 < (n / 2); i2++) {
                        a.add(color);
                    }
                    for (int i2 = 0; i2 < ((n + 1) / 2); i2++) {
                        b.add(color);
                    }
                    color++;
                }
            }
        }
        for (int i = b.size() - 1; i >= 0; i--) {
            a.add(b.get(i));
        }
        for (int i = 0, t = 4000 - a.size(); i < t; i++) {
            a.add(color);
        }
        sb.append("1\n").append(a.size()).append(" ").append(k).append("\n");
        for (Integer integer : a) {
            sb.append(integer).append(' ');
        }
        System.out.println("test case:");
        System.out.println(sb);
        String input = sb.toString();
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        long t = System.currentTimeMillis();
        System.out.println("output:");
        // 正确结果为0
        Main.main(null);
        System.out.println("time cost:");
        System.out.println((double) (System.currentTimeMillis() - t) / 1000 + "s");
    }

    static HashMap<String, Long> C = new HashMap<>();
    static long C(int n, int k) {
        C.computeIfAbsent(n + " " + k, t -> fac(n).divide(fac(n - k)).divide(fac(k)).longValueExact());
        return C.get(n + " " + k);
    }

    static HashMap<Integer, BigInteger> fac = new HashMap<>();
    static BigInteger fac(int n) {
        fac.computeIfAbsent(n, t1 -> {
            BigInteger t = BigInteger.valueOf(1);
            for (int i = 2; i <= n; i++) {
                t = t.multiply(BigInteger.valueOf(i));
            }
            return t;
        });
        return fac.get(n);
    }
}
