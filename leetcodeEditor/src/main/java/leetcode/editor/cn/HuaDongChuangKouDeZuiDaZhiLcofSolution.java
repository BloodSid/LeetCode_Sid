package leetcode.editor.cn;

import java.util.*;

/**
 * 滑动窗口的最大值
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-23 13:14:07
 */
public class HuaDongChuangKouDeZuiDaZhiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> maxQueue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // 队头到队尾单调减
            while (!maxQueue.isEmpty() && nums[i] > nums[maxQueue.peekLast()]) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(i);
            if (i >= k - 1) {
                if (maxQueue.peekFirst() == i - k) {
                    maxQueue.pollFirst();
                }
                res[i - k + 1] = nums[maxQueue.peekFirst()];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
