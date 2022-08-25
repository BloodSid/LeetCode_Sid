package leetcode.editor.cn;
//给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。 
//
// 请你计算并返回该式的最大值。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,5,2]
//输出：12 
//解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) =
// 3*4 = 12 。 
// 
//
// 示例 2： 
//
// 输入：nums = [1,5,4,5]
//输出：16
//解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
// 
//
// 示例 3： 
//
// 输入：nums = [3,7]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 500 
// 1 <= nums[i] <= 10^3 
// 
// 👍 39 👎 0


/**
 * 数组中两元素的最大乘积
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-26 00:07:21 
 */
public class MaximumProductOfTwoElementsInAnArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int x = 0, y = 0;
        for (int i : nums) {
            if (i >= x) {
                y = x;
                x = i;
            } else if (i >= y){
                y = i;
            }
        }
        return (x - 1) * (y - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
