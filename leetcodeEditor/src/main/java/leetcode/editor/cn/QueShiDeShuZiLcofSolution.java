package leetcode.editor.cn;

import java.util.*;

/**
 * 0～n-1中缺失的数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-30 21:36:50
 */
public class QueShiDeShuZiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int ans = n - 1;
        for (int i = 0; i < n - 1; i++) {
            ans ^= i;
            ans ^= nums[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
