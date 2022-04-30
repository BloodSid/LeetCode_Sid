package leetcode.editor.cn;

/**
 * 第 k 个缺失的正整数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-19 09:29:25 
 */
public class KthMissingPositiveNumberSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (arr[mid] - mid - 1 >= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (r == -1) return k;
        return arr[r] + k - (arr[r] - r - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
