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
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
                int top = stack.pollLast();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peekLast();
                ans += (i - left - 1) * (Math.min(height[left], height[i]) - height[top]);
            }
            stack.offerLast(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
