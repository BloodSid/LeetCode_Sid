package leetcode.editor.cn;

/**
 * 统计按位或能得到最大值的子集数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-15 00:15:27 
 */
public class CountNumberOfMaximumBitwiseOrSubsetsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // TODO 试试别的解法
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max |= num;
        }
        int n = nums.length;
        int cnt = 0;
        loop:
        for (int i = 0; i < 1 << n; i++) {
            int or = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    or |= nums[j];
                }
                if (or == max) {
                    cnt++;
                    continue loop;
                }
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
