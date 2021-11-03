package leetcode.editor.cn;

import java.util.*;

/**
 * 接雨水
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-03 12:18:15
 */
public class TrappingRainWaterSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int[] ans = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            ans[i] = max;
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            ans[i] = Math.min(max, ans[i]);
        }
        int sum = 0;
        for (int i = 0; i < ans.length; i++) {
            sum += ans[i] - height[i];
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
