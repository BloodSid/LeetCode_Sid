package leetcode.editor.cn;
//给你一个整数数组 nums 和一个 正 整数 k 。你可以选择数组的任一 子序列 并且对其全部元素求和。 
//
// 数组的 第 k 大和 定义为：可以获得的第 k 个 最大 子序列和（子序列和允许出现重复） 
//
// 返回数组的 第 k 大和 。 
//
// 子序列是一个可以由其他数组删除某些或不删除元素排生而来的数组，且派生过程不改变剩余元素的顺序。 
//
// 注意：空子序列的和视作 0 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,4,-2], k = 5
//输出：2
//解释：所有可能获得的子序列和列出如下，按递减顺序排列：
//- 6、4、4、2、2、0、0、-2
//数组的第 5 大和是 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,-2,3,4,-10,12], k = 16
//输出：10
//解释：数组的第 16 大和是 10 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 1 <= k <= min(2000, 2ⁿ) 
// 
//
// 👍 85 👎 0


import java.util.*;

/**
 * 找出数组的第 K 大和
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-03-09 00:30:10 
 */
public class FindTheKSumOfAnArraySolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long kSum(int[] nums, int k) {
        // pos 记录所有正数之和，对应原数组第1大子序列和
        long pos = 0;
        int n = nums.length;
        // 从 sum(pos) 中去掉正数，或者向其中加入负数的操作，都等价于减去 abs(nums[i]) 的操作
        // 减去的数越小，子序列和越大。问题转化为从 abs(nums) 上获得第k小的子序列。
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                pos += nums[i];
            } else {
                nums[i] = -nums[i];
            }
        }

        // 类 Dijkstra 求 abs(nums) 求第k小的子序列
        Arrays.sort(nums);
        // {子序列之和sum，序列末尾元素下标i}
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        // 空集对应最小的nums的子序列之和，而 {nums[0], 0} 表示集合 {nums[0]}, 对应第2小的集合
        pq.offer(new long[]{nums[0], 0});
        long res = 0;
        // 不重不漏地生成所有子序列：类似Dijkstra算法由近及远找点，每轮出堆的元素和是非降的，所以会按照从小到大的顺序生成所有子序列
        for (int ki = 0; ki < k - 1; ki++) {
            long[] p = pq.poll();
            int i = (int) p[1];
            res = p[0];
            if (i == n - 1) {
                continue;
            }
            // 替换末尾元素为下一个元素
            pq.offer(new long[]{p[0] - nums[i] + nums[i + 1], i + 1});
            // 添加下一个元素
            pq.offer(new long[]{p[0] + nums[i + 1], i + 1});
        }
        return pos - res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
