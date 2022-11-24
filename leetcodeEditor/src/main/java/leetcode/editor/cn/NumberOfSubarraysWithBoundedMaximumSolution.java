package leetcode.editor.cn;
//给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组
//，并返回满足条件的子数组的个数。 
//
// 生成的测试用例保证结果符合 32-bit 整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,4,3], left = 2, right = 3
//输出：3
//解释：满足条件的三个子数组：[2], [2, 1], [3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,9,2,5,6], left = 2, right = 8
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= left <= right <= 10⁹ 
// 
// 👍 323 👎 0


/**
 * 区间子数组个数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-11-24 23:52:44 
 */
public class NumberOfSubarraysWithBoundedMaximumSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0;
        int n = nums.length;
        // p2 记录最后一个大于上限的元素位置, p1 记录最后一个符合上下限的元素位置
        int p1 = -1, p2 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                p1 = i;
            } else if (nums[i] > right) {
                p2 = i;
                p1 = -1;
            }
            if (p1 != -1) {
                res += p1 - p2;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
