package leetcode.editor.cn;

/**
 * 乘法表中第k小的数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-18 01:32:38 
 */
public class KthSmallestNumberInMultiplicationTableSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthNumber(int m, int n, int k) {
        if (m > n) return findKthNumber(n, m, k);
        // m <= n
        int l = 1, r = m * n;
        while (l <= r) {
            int mid = l + r >> 1;
            int cnt = 0;
            for (int i = 1; i <= m; i++) {
                int t = mid / i;
                if (t == 0) break;
                cnt += Math.min(n, t);
            }
            if (cnt >= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
