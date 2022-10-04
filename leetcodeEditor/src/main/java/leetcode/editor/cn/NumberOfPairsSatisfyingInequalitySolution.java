package leetcode.editor.cn;
//给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两个数组的大小都为 n ，同时给你一个整数 diff ，统计满足以下条件的 数对 (i, 
//j) ： 
//
// 
// 0 <= i < j <= n - 1 且 
// nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff. 
// 
//
// 请你返回满足条件的 数对数目 。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [3,2,5], nums2 = [2,2,1], diff = 1
//输出：3
//解释：
//总共有 3 个满足条件的数对：
//1. i = 0, j = 1：3 - 2 <= 2 - 2 + 1 。因为 i < j 且 1 <= 1 ，这个数对满足条件。
//2. i = 0, j = 2：3 - 5 <= 2 - 1 + 1 。因为 i < j 且 -2 <= 2 ，这个数对满足条件。
//3. i = 1, j = 2：2 - 5 <= 2 - 1 + 1 。因为 i < j 且 -3 <= 2 ，这个数对满足条件。
//所以，我们返回 3 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [3,-1], nums2 = [-2,2], diff = -1
//输出：0
//解释：
//没有满足条件的任何数对，所以我们返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length == nums2.length 
// 2 <= n <= 10⁵ 
// -10⁴ <= nums1[i], nums2[i] <= 10⁴ 
// -10⁴ <= diff <= 10⁴ 
// 
// 👍 6 👎 0


/**
 * 满足不等式的数对数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-04 19:37:49 
 */
public class NumberOfPairsSatisfyingInequalitySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

}

//leetcode submit region end(Prohibit modification and deletion)

}
