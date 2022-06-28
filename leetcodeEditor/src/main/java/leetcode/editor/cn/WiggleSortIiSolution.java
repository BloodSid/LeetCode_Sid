package leetcode.editor.cn;
//给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。 
//
// 你可以假设所有输入数组都可以得到满足题目要求的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,1,1,6,4]
//输出：[1,6,1,5,1,4]
//解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,2,2,3,1]
//输出：[2,3,1,3,1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// 0 <= nums[i] <= 5000 
// 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果 
// 
//
// 
//
// 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？ 
// 👍 411 👎 0


import java.util.Arrays;

/**
 * 摆动排序 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-28 12:56:10 
 */
public class WiggleSortIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        int mid = (n + 1) >> 1;
        // 顺序插入会碰到相邻的元素相等的情况，如nums = [4,5,5,6]
        for (int i = mid - 1, j = 0; i >= 0; i--) {
            nums[j] = copy[i];
            j += 2;
        }
        for (int i = n - 1, j = 1; i >= mid; i--) {
            nums[j] = copy[i];
            j += 2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
