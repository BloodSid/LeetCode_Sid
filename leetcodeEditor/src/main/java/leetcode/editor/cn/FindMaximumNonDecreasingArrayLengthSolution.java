package leetcode.editor.cn;
//给你一个下标从 0 开始的整数数组 nums 。 
//
// 你可以执行任意次操作。每次操作中，你需要选择一个 子数组 ，并将这个子数组用它所包含元素的 和 替换。比方说，给定数组是 [1,3,5,6] ，你可以选择
//子数组 [3,5] ，用子数组的和 8 替换掉子数组，然后数组会变为 [1,8,6] 。 
//
// 请你返回执行任意次操作以后，可以得到的 最长非递减 数组的长度。 
//
// 子数组 指的是一个数组中一段连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,2]
//输出：1
//解释：这个长度为 3 的数组不是非递减的。
//我们有 2 种方案使数组长度为 2 。
//第一种，选择子数组 [2,2] ，对数组执行操作后得到 [5,4] 。
//第二种，选择子数组 [5,2] ，对数组执行操作后得到 [7,2] 。
//这两种方案中，数组最后都不是 非递减 的，所以不是可行的答案。
//如果我们选择子数组 [5,2,2] ，并将它替换为 [9] ，数组变成非递减的。
//所以答案为 1 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：4
//解释：数组已经是非递减的。所以答案为 4 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [4,3,2,6]
//输出：3
//解释：将 [3,2] 替换为 [5] ，得到数组 [4,5,6] ，它是非递减的。
//最大可能的答案为 3 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 👍 8 👎 0


import java.util.Arrays;

/**
 * 找到最大非递减数组的长度
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-11-27 16:28:06 
 */
public class FindMaximumNonDecreasingArrayLengthSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaximumLength(int[] nums) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + nums[i];
        int[] f = new int[n + 1];
        int[] pre = new int[n + 2];
        int j = 0;
        for (int i = 1; i <= n; i++) {
            // pre[i] 可能因为没有直接转移到的状态所以此时是0，这时采用pre[i-1] 的值。j 是单调增的。
            j = Math.max(j, pre[i]);
            // 贪心，从最近的前一个元素转移过来，因为 f 是单调增的，所以必然取得最大值
            f[i] = f[j] + 1;
            // 找到 k, 使得不等式成立且k 最小 sum[i] - sum[j] <= sum[k] - sum[i]
            int l = i + 1, r = n;
            while (l <= r) {
                int mid = l + r >> 1;
                if (sum[mid] < sum[i] * 2 - sum[j]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            int k = l;
            pre[k] = i;
        }
        return f[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
