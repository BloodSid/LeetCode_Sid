package leetcode.editor.cn;
//给你一个数组 nums ，它包含 n 个正整数。你需要计算所有非空连续子数组的和，并将它们按升序排序，得到一个新的包含 n * (n + 1) / 2 个数
//字的数组。 
//
// 请你返回在新数组中下标为 left 到 right （下标从 1 开始）的所有数字和（包括左右端点）。由于答案可能很大，请你将它对 10^9 + 7 取模
//后返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4], n = 4, left = 1, right = 5
//输出：13 
//解释：所有的子数组和为 1, 3, 6, 10, 2, 5, 9, 3, 7, 4 。将它们升序排序后，我们得到新的数组 [1, 2, 3, 3, 4, 5
//, 6, 7, 9, 10] 。下标从 le = 1 到 ri = 5 的和为 1 + 2 + 3 + 3 + 4 = 13 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4], n = 4, left = 3, right = 4
//输出：6
//解释：给定数组与示例 1 一样，所以新数组为 [1, 2, 3, 3, 4, 5, 6, 7, 9, 10] 。下标从 le = 3 到 ri = 4 的和
//为 3 + 3 = 6 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,4], n = 4, left = 1, right = 10
//输出：50
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^3 
// nums.length == n 
// 1 <= nums[i] <= 100 
// 1 <= left <= right <= n * (n + 1) / 2 
// 
// 👍 54 👎 0


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 子数组和排序后的区间和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-10 18:18:43 
 */
public class RangeSumOfSortedSubarraySumsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int MOD = (int) (1e9 + 7);


    public int rangeSum(int[] nums, int n, int left, int right) {
        // TODO 二分搜索做法
        int m = n * (n + 1) / 2;
        int[] p = new int[n + 1];
        for (int i = 0, t = 0; i < n; i++) {
            t += nums[i];
            p[i + 1] = t;
        }
        // 初始化每一行数组和的头指针
        int[] head = new int[n];
        for (int i = 0; i < n; i++) {
            head[i] = i + 1;
        }
        // 多路归并排序数组和
        PriorityQueue<Integer> pq = new PriorityQueue<>(n, Comparator.comparingInt(i -> p[head[i]] - p[i]));
        for (int i = 0; i < n; i++) pq.offer(i);
        int[] sub = new int[m];
        int k = 0;
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            sub[k++] = p[head[poll]++] - p[poll];
            if (head[poll] <= n) pq.offer(poll);
        }
        long sum = 0;
        for (int i = left - 1; i <= right - 1; i++) {
            sum += sub[i];
        }
        return (int) (sum % MOD);
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
