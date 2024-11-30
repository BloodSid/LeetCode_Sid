package leetcode.editor.cn;
//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
//
// 👍 1018 👎 0


/**
 * 有序数组的平方
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-09-08 02:05:23 
 */
public class SquaresOfASortedArraySolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] sq = new int[n];
        int k = n-1;
        for (int i = 0, j = n - 1; i <= j; ) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                sq[k--] = nums[i] * nums[i];
                i++;
            } else {
                sq[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return sq;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
