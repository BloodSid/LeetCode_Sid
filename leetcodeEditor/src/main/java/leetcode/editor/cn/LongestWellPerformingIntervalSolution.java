package leetcode.editor.cn;
//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 示例 2： 
//
// 
//输入：hours = [6,6,6]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10⁴ 
// 0 <= hours[i] <= 16 
// 
//
// 👍 296 👎 0


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 表现良好的最长时间段
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-02-14 10:09:03
 */
public class LongestWellPerformingIntervalSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        // 用前缀和表示一段时间内两种天数之差
        int[] pre = new int[n + 1];
        for (int i = 0; i < hours.length; i++) {
            pre[i + 1] = pre[i] + (hours[i] > 8 ? 1 : -1);
        }
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        // 找出可能作为结果的左边界
        for (int i = 1; i <= n; i++) {
            if (stack.isEmpty() || pre[stack.peek()] > pre[i]) {
                stack.push(i);
            }
        }
        for (int i = n; i > 0; i--) {
            while (!stack.isEmpty() && pre[stack.peek()] < pre[i]) {
                int pop = stack.pop();
                // [pop, i) 可能是满足条件的最长子数组
                max = Math.max(max, i - pop);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
