package leetcode.editor.cn;

import java.util.*;

/**
 * 统计特殊四元组
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-29 17:43:21
 */
public class CountSpecialQuadrupletsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countQuadruplets(int[] nums) {
        int cnt = 0;
        int[] freq = new int[201];
        int n = nums.length;
        for (int b = n - 3; b > 0; b--) {
            for (int d = b + 2; d < n; d++) {
                int diff = nums[d] - nums[b + 1];
                if (diff >= 2) {
                    freq[diff]++;
                }
            }
            for (int a = 0; a < b; a++) {
                cnt += freq[nums[a] + nums[b]];
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
