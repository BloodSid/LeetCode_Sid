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
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) s[i + 1] = s[i] + nums[i];
        // f[i] 表示操作nums[0:i]所得到的最长非递减数组的长度。f 是单调递增的，找到最大的j就找到最大的f[j]
        int[] f = new int[n + 1];
        // last[i] 表示在 f[i]尽量大的前提下，nums[0:i]操作后的最后一个数的最小值
        long[] last = new long[n + 1];
        // 设j是i的转移来源，则满足条件 s[i] - s[j] >= last[j]，变形得 s[i] >= last[j] + s[j]
        // 用单调队列来维护 last[j] + s[j] 保证队列中 j 和 last[j] + s[j] 都是单调增的
        int[] q = new int[n + 1];
        // 队列初始化长度1
        int head = 0, tail = 0;
        for (int i = 1; i <= n; i++) {
            // 去掉队首无用数据（计算转移时直接取队尾）：如果队首第二个元素满足不等式，说明第一个元素可以去掉
            while (head < tail && s[q[head + 1]] + last[q[head + 1]] <= s[i]) {
                head++;
            }
            // 计算转移
            f[i] = f[q[head]] + 1;
            last[i] = s[i] - s[q[head]];
            // 去掉队尾无用数据。设有两个转移来源 j1 < j2, 且 s[j1]+last[j1]>=s[j2]+last[j2],
            // 如果能从 f[j1] 转移到 f[i] 那么从 f[j2] 也能，且 f[j2] >= f[j1], j1 可以不再考虑，即队列尾部大于当前元素的去除
            while (head <= tail && s[q[tail]] + last[q[tail]]  >= s[i] + last[i]) {
                tail--;
            }
            q[++tail] = i;
        }
        return f[n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
