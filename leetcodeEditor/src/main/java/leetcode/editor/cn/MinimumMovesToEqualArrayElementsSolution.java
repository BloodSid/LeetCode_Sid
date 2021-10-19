package leetcode.editor.cn;

import java.util.*;

/**
 * 最小操作次数使数组元素相等
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-20 00:11:00 
 */
public class MinimumMovesToEqualArrayElementsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int ans = 0;
        for (int num : nums) {
            ans += num - min;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
