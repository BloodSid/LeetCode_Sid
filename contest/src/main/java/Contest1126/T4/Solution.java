package Contest1126.T4;

/**
 * @author IronSid
 * @since 2022-11-26 22:25
 */
public class Solution {

    public static final int MOD = (int) (1e9 + 7);

    public int countPalindromes(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        // 不同字符数量的前缀和
        int[][] f = new int[10][n + 1];
        long[][] pref = new long[10][n + 1];
        long[][] prexf = new long[10][n + 1];
        int[] t = new int[10];
        long[] pret = new long[10];
        long[] prext = new long[10];
        for (int i = 0; i < n; i++) {
             int cur = c[i] - '0';
             t[cur]++;
             pret[cur] += t[cur];
             prext[cur] += (long) i * t[cur];
             pret[cur] %= MOD;
             prext[cur] %= MOD;
            for (int j = 0; j < 10; j++) {
                f[j][i + 1] = t[j];
                pref[j][i + 1] = pret[j];
                prexf[j][i + 1] = prext[j];
            }
        }
        // res[x] 表示以 x 结尾的长度5的回文子序列数量
        long[] res = new long[10];
        // 回文为 k l m l k 枚举第四个字符的位置
        for (int j = 3; j < n; j++) {
            // 枚举第五个字符 k
            for (int k = 0; k < 10; k++) {
                // 计算所有合法的第二个字符的贡献之和
                res[k] += (f[k][n] - f[k][j + 1]) * (((j + 1) * pref[k][j] - prexf[k][j]) % MOD + MOD);
                res[k] %= MOD;
            }
        }
        long sum = 0;
        for (long re : res) {
            sum += re;
        }
        return (int) (sum % MOD);
    }
}
