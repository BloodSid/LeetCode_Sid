package leetcode.editor.cn;

import java.util.*;

/**
 * 统计元音字母序列的数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-17 10:00:38
 */
public class CountVowelsPermutationSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countVowelPermutation(int n) {
        int MOD = (int) (1e9 + 7);
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int j = 1; j < n; j++) {
            int ta = a, te = e, ti = i, to = o, tu = u;
            a = (int) (((long) te + ti + tu) % MOD);
            e = (ta + ti) % MOD;
            i = (te + to) % MOD;
            o = ti;
            u = (ti + to) % MOD;
        }
        long sum = (long) a + e + i + o + u;
        return (int) (sum % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
