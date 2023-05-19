package leetcode.editor.cn;
//你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。 
//
// 注意：本题中，每个活字字模只能使用一次。 
//
// 
//
// 示例 1：
//
// 
//输入："AAB"
//输出：8
//解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
// 
//
// 示例 2： 
//
// 
//输入："AAABBC"
//输出：188
// 
//
// 示例 3： 
//
// 
//输入："V"
//输出：1 
//
// 
//
// 提示： 
//
// 
// 1 <= tiles.length <= 7 
// tiles 由大写英文字母组成 
// 
//
// 👍 169 👎 0


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 活字印刷
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-19 00:04:09 
 */
public class LetterTilePossibilitiesSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int M = (int) (1e9 + 7);
    public static final BigInteger BIM = BigInteger.valueOf(M);
    public static final int N = (int) (1e5);
    private char[] ch;
    private HashSet<String> set;
    static HashMap<String, Long> C = new HashMap<>();

    static long C(int n, int k) {
        C.computeIfAbsent(n + " " + k, t ->
                fac(n).multiply(fac(n - k).modInverse(BIM)).multiply(fac(k).modInverse(BIM)).mod(BIM).longValueExact()
        );
        return C.get(n + " " + k);
    }

    static List<Long> fac= new ArrayList<>((int) (N + 10));
    static {
        fac.add(1L);
    }

    static BigInteger fac(int n) {
        for (int i = fac.size(); i <= n; i++) {
            fac.add(fac.get(i - 1) * i % M);
        }
        return BigInteger.valueOf(fac.get(n));
    }

    public int numTilePossibilities(String tiles) {
        List<Integer> list = new ArrayList<>();
        int[] f = new int[128];
        for (char c : tiles.toCharArray()) {
            f[c]++;
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if (f[c] != 0) list.add(f[c]);
        }
        int m = list.size();
        int n = tiles.length();
        // dp[i][j] 表示前 i 种字符构造长为 j 的序列的方案数
        long[][] dp = new long[m + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            int cnt = list.get(i - 1);
            // 枚举序列列长度
            for (int j = 0; j <= n; j++) {
                // 枚举取多少个当前字符
                for (int k = 0; k <= j && k <= cnt; k++) {
                    dp[i][j] += dp[i - 1][j - k] * C(j, k);
                }
            }
        }
        long ans = 0;
        for (int j = 1; j <= n; j++) {
            ans += dp[m][j];
        }
        return (int) ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
