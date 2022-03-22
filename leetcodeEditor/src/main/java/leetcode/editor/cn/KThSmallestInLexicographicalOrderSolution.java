package leetcode.editor.cn;

/**
 * 字典序的第K小数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-23 00:01:12 
 */
public class KThSmallestInLexicographicalOrderSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int size = getSize(cur, n);
            if (k < size) {
                k--;
                cur *= 10;
            } else {
                k -= size;
                cur++;
            }
        }
        return cur;
    }

    // 求以cur为根的字典树的大小
    private int getSize(int cur, int n) {
        long left = cur, right = cur;
        int size = 0;
        while (left <= n) {
            size += Math.min(right, n) - left + 1;
            left *= 10;
            right = right * 10 + 9;
        }
        return size;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
