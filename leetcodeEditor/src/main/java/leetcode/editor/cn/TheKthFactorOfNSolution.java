package leetcode.editor.cn;

/**
 * n 的第 k 个因子
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-17 23:01:11
 */
public class TheKthFactorOfNSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthFactor(int n, int k) {
        for (int i = 1; i <= n; i++) {
            if (n % i != 0) continue;
            if (--k == 0) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
