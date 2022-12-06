package leetcode.editor.cn;
//给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。 
//
// 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。 
//
// 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
//输出：3
//解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//- 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
//- 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
//- 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
//输出：-1
//解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
// 
//
// 示例 3： 
//
// 输入：nums1 = [6,6], nums2 = [1]
//输出：3
//解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//- 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
//- 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
//- 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// 1 <= nums1[i], nums2[i] <= 6 
// 
// 👍 58 👎 0


/**
 * 通过最少操作次数使数组的和相等
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-12-07 00:10:50 
 */
public class EqualSumArraysWithMinimumNumberOfOperationsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) return minOperations(nums2, nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2 * 6) return -1;
        int s1 = 0, s2 = 0;
        int[] f1 = new int[7], f2 = new int[7];
        for (int i : nums1) {
            s1 += i;
            f1[i]++;
        }
        for (int i : nums2) {
            s2 += i;
            f2[i]++;
        }
        // 确保 s1 <= s2;
        if (s1 > s2) {
            int t = s1; s1 = s2; s2 = t;
            int[] tf = f1; f1 = f2; f2 = tf;
        }
        int res = 0;
        int p1 = 1, p2 = 6;
        for (int d = s2 - s1; d > 0; res++) {
            while (p1 <= 5 && f1[p1] == 0) p1++;
            while (p2 >= 2 && f2[p2] == 0) p2--;
            if (6 - p1 > p2 - 1) {
                f1[p1]--;
                d -= 6 - p1;
            } else {
                f2[p2]--;
                d -= p2 - 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
