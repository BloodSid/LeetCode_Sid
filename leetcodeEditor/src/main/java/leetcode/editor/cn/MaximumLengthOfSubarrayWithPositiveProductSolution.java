package leetcode.editor.cn;
//给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。 
//
// 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。 
//
// 请你返回乘积为正数的最长子数组长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-2,-3,4]
//输出：4
//解释：数组本身乘积就是正数，值为 24 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,-2,-3,-4]
//输出：3
//解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
//注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-2,-3,0,1]
//输出：2
//解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^9 <= nums[i] <= 10^9 
// 
//
// 
// 👍 160 👎 0


/**
 * 乘积为正数的最长子数组长度
 *
 * @author IronSid
 * @since 2022-06-09 20:35:51 
 * @version 1.0
 */
public class MaximumLengthOfSubarrayWithPositiveProductSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getMaxLen(int[] nums) {
        int max = 0;
        int positive = 0;
        int negative = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                positive = Math.max(1, positive + 1);
                negative = negative == 0 ? 0 : negative + 1;
            } else if (nums[i] == 0) {
                positive = 0;
                negative = 0;
            } else {
                int temp = positive;
                positive = negative == 0 ? 0 : negative + 1;
                negative = Math.max(1, temp + 1);
            }
            max = Math.max(max, positive);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
