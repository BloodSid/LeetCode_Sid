package leetcode.editor.cn;


/**
 * 差的绝对值为 K 的数对数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-09 00:25:07
 */
public class CountNumberOfPairsWithAbsoluteDifferenceKSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }
        int cnt = 0;
        for (int i = 1; i < freq.length - k; i++) {
            cnt += freq[i] * freq[i + k];
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
