package leetcode.editor.cn;

/**
 * 构造字符串的总得分和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-03 15:39:54 
 */
public class SumOfScoresOfBuiltStringsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int MOD = (int) (1e9 + 7);
    public static final int BASE = 173;

    public long sumScores(String s) {
        // 滚动哈希
        int n = s.length();
        char[] val = s.toCharArray();
        long[] p = new long[n + 1];
        long[] h = new long[n + 1];
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * BASE % MOD;
            h[i] = (h[i - 1] * BASE + val[i - 1]) % MOD;
        }
        long score = 0;
        for (int i = n - 1; i >= 0; i--) {
            int l = 0, r = n - i;
            while (l <= r) {
                int mid = l + r >> 1;
                // si 的前缀s[i, i + mid)的哈希值
                long preHash = (h[i + mid] - h[i] * p[mid]) % MOD;
                if (preHash < 0) preHash += MOD;
                if (h[mid] == preHash){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            score += r;
        }
        return score;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
