package leetcode.editor.cn;
//给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且全部数字和（3 * k 项）最大的子数组，并返回这三个子数组。 
//
// 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,2,6,7,5,1], k = 2
//输出：[0,3,5]
//解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
//也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
//输出：[0,2,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] < 2¹⁶ 
// 1 <= k <= floor(nums.length / 3) 
// 
//
// 👍 400 👎 0


/**
 * 三个无重叠子数组的最大和
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-11-20 10:28:57 
 */
public class MaximumSumOf3NonOverlappingSubarraysSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        // 开始下标为 i 的子数组对应的和
        int[] sum = new int[n - k + 1];
        int t = 0;
        for (int i = 0; i < k; i++) {
            t += nums[i];
        }
        // 滑窗求各个子数组的和
        sum[0] = t;
        for (int i = k; i < n; i++) {
            t += nums[i] - nums[i - k];
            sum[i - k + 1] = t;
        }
        // 枚举第二个数组，前后缀分解，第二个数组的起始下标范围是 [k, n-2k], p1 和 p3 分别维护前后两个子数组的最大值的下标
        int[] p1 = new int[n - 3 * k + 1], p3 = new int[n - 3 * k + 1];
        // p 维护最大子数组的下标
        for(int i = 0, p = 0; i <= n - 3 * k; i++) {
            if (sum[i] > sum[p]) p = i;
            p1[i] = p;
        }
        for (int i = n - 3 * k, p = n - k; i >= 0; i--) {
            // 结果字典序最小，所以相等的时候也更新p
            if (sum[i + 2 * k] >= sum[p]) {
                p = i + 2 * k;
            }
            p3[i] = p;
        }
        int[] res = null;
        int max = 0;
        for(int i = 0; i <= n - 3 * k; i++) {
            int cur = sum[p1[i]] + sum[p3[i]] + sum[i + k];
            if (cur > max) {
                max = cur;
                res = new int[]{p1[i], i + k, p3[i]};
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
