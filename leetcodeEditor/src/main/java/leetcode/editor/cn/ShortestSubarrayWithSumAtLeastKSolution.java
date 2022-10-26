package leetcode.editor.cn;
//给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 
//-1 。 
//
// 子数组 是数组中 连续 的一部分。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2], k = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-1,2], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= k <= 10⁹ 
// 
// 👍 449 👎 0


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 和至少为 K 的最短子数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-26 00:00:12 
 */
public class ShortestSubarrayWithSumAtLeastKSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // 前缀和，pre[j] - pre[i] 表示子数组 nums[i, j - 1], 所求的就是满足 pre[j] - pre[i] >= k 时，j - i 的最小值
        long[] pre = new long[n + 1];
        long t = 0;
        for (int i = 0; i < n; i++) {
            t += nums[i];
            pre[i + 1] = t;
        }
        int shortest = n + 1;
        // 用单调队列存可用的 i 的下标，因为 pre[i] 越小越容易满足上述不等式，所以每个 i 入队时都要把队尾更大的元素去掉
        // 即队列中的元素单调增
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        for (int j = 1; j <= n; j++) {
            // 把队尾更大的元素去掉
            while (!q.isEmpty() && pre[q.peekLast()] >= pre[j]) {
                q.pollLast();
            }
            q.offerLast(j);
            // 把队首满足不等式的元素去掉，并同时更新最短值
            while (!q.isEmpty() && pre[j] - pre[q.peekFirst()] >= k) {
                shortest = Math.min(shortest, j - q.pollFirst());
            }
        }
        // 若未找到则返回 -1
        return shortest == n + 1 ? -1 : shortest;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
