package leetcode.editor.cn;
//给你一个下标从 0 开始长度为 n 的数组 nums 。 
//
// 每一秒，你可以对数组执行以下操作： 
//
// 
// 对于范围在 [0, n - 1] 内的每一个下标 i ，将 nums[i] 替换成 nums[i] ，nums[(i - 1 + n) % n] 或者 
//nums[(i + 1) % n] 三者之一。 
// 
//
// 注意，所有元素会被同时替换。 
//
// 请你返回将数组 nums 中所有元素变成相等元素所需要的 最少 秒数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,1,2]
//输出：1
//解释：我们可以在 1 秒内将数组变成相等元素：
//- 第 1 秒，将每个位置的元素分别变为 [nums[3],nums[1],nums[3],nums[3]] 。变化后，nums = [2,2,2,2] 。
//
//1 秒是将数组变成相等元素所需要的最少秒数。
// 
//
// 示例 2： 
//
// 输入：nums = [2,1,3,3,2]
//输出：2
//解释：我们可以在 2 秒内将数组变成相等元素：
//- 第 1 秒，将每个位置的元素分别变为 [nums[0],nums[2],nums[2],nums[2],nums[3]] 。变化后，nums = [2,
//3,3,3,3] 。
//- 第 2 秒，将每个位置的元素分别变为 [nums[1],nums[1],nums[2],nums[3],nums[4]] 。变化后，nums = [3,
//3,3,3,3] 。
//2 秒是将数组变成相等元素所需要的最少秒数。
// 
//
// 示例 3： 
//
// 输入：nums = [5,5,5,5]
//输出：0
//解释：不需要执行任何操作，因为一开始数组中的元素已经全部相等。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n == nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 👍 50 👎 0


import java.util.*;

/**
 * 使循环数组所有元素相等的最少秒数
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-01-30 14:19:47 
 */
public class MinimumSecondsToEqualizeACircularArraySolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumSeconds(List<Integer> ns) {
        int n = ns.size();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = ns.get(i);
        }
        // 离散化，将原来的元素离散化到[0,n-1]
        int m = 0;
        HashMap<Integer, Integer> id = new HashMap<>();
        // lasti 记录元素 id[num] 最后出现的位置
        int[] last = new int[n];
        for (int i = 0; i < nums.length; i++) {
            if (!id.containsKey(nums[i])) {
                id.put(nums[i], m);
                m++;
            }
            last[id.get(nums[i])] = i;
        }
        // 由于是循环数组，所以此时的 last 数组对应 i = 0 时的状态
        // 计算每种元素在循环数组上空隙的最大值
        int[] max = new int[m];
        for (int i = 0; i < n; i++) {
            int idx = id.get(nums[i]);
            // 位置i和他自己的距离为n
            max[idx] = Math.max(max[idx], (i + n - 1 - last[idx]) % n + 1);
            last[idx] = i;
        }
        // 空隙最大值最小的元素作为最终元素
        int min = Integer.MAX_VALUE;
        for (int i : max) {
            min = Math.min(min, i);
        }
        return min / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
