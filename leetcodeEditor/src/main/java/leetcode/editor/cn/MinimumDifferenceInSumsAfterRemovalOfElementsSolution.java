package leetcode.editor.cn;

import java.util.*;

/**
 * 删除元素后和的最小差值
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-06 18:44:33
 */
public class MinimumDifferenceInSumsAfterRemovalOfElementsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 记录左半部分在长度从 n 到 2n 时的最小值
        long[] firstMin = new long[n + 1];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            left.add(nums[i]);
            sum += nums[i];
        }
        firstMin[0] = sum;
        for (int i = 1; i <= n; i++) {
            int cur = nums[n - 1 + i];
            left.offer(cur);
            sum += cur - left.poll();
            firstMin[i] = sum;
        }
        PriorityQueue<Integer> right = new PriorityQueue<>();
        sum = 0;
        for (int i = 2 * n; i < 3 * n; i++) {
            right.add(nums[i]);
            sum += nums[i];
        }
        long minDiff = firstMin[n] - sum;
        for (int i = 1; i <= n; i++) {
            int cur = nums[2 * n - i];
            right.offer(cur);
            sum += cur - right.poll();
            minDiff = Math.min(minDiff, firstMin[n - i] - sum);
        }
        return minDiff;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
