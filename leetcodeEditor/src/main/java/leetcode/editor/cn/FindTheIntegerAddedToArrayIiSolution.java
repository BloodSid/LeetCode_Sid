package leetcode.editor.cn;
//给你两个整数数组 nums1 和 nums2。 
//
// 从 nums1 中移除两个元素，并且所有其他元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。 
//
// 执行上述操作后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。 
//
// 返回能够实现数组相等的 最小 整数 x 。 
//
// 
//
// 示例 1: 
//
// 
// 输入：nums1 = [4,20,16,12,8], nums2 = [14,18,10] 
// 
//
// 输出：-2 
//
// 解释： 
//
// 移除 nums1 中下标为 [0,4] 的两个元素，并且每个元素与 -2 相加后，nums1 变为 [18,14,10] ，与 nums2 相等。 
//
// 示例 2: 
//
// 
// 输入：nums1 = [3,5,5,3], nums2 = [7,7] 
// 
//
// 输出：2 
//
// 解释： 
//
// 移除 nums1 中下标为 [0,3] 的两个元素，并且每个元素与 2 相加后，nums1 变为 [7,7] ，与 nums2 相等。 
//
// 
//
// 提示： 
//
// 
// 3 <= nums1.length <= 200 
// nums2.length == nums1.length - 2 
// 0 <= nums1[i], nums2[i] <= 1000 
// 测试用例以这样的方式生成：存在一个整数 x，nums1 中的每个元素都与 x 相加后，再移除两个元素，nums1 可以与 nums2 相等。 
// 
//
// 👍 41 👎 0


import java.util.Arrays;

/**
 * 找出与数组相加的整数 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-08-09 23:38:14 
 */
public class FindTheIntegerAddedToArrayIiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums2.length;
        // 倒着枚举nums[2-0], nums[i]越大x越小，第一个就是答案
        for (int i = 2; i >= 0; i--) {
            int x = nums2[0] - nums1[i];
            // 检查 {nums1[i:]+1} 是否拥有子序列 nums2
            for (int j = i, k = 0; j < n + 2; j++) {
                if (nums1[j] + x == nums2[k]) {
                    k++;
                    if (k == n) return x;
                }
            }
        }
        return nums2[0] - nums1[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
