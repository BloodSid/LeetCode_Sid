package leetcode.editor.cn;
//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
// 👍 1684 👎 0


/**
 * 乘积最大子数组
 *
 * @author IronSid
 * @since 2022-06-09 20:02:46 
 * @version 1.0
 */
public class MaximumProductSubarraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int minSub = 1, maxSub = 1;
        for (int i = 0; i < nums.length; i++) {
            int temp = minSub;
            minSub = Math.min(nums[i], Math.min(minSub * nums[i], maxSub * nums[i]));
            maxSub = Math.max(nums[i], Math.max(temp * nums[i], maxSub * nums[i]));
            max = Math.max(maxSub, max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
