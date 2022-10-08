package leetcode.editor.cn;
//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的
//数目来描述。 
//
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
// 👍 323 👎 0


import java.util.*;

/**
 * 优势洗牌
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-08 22:25:30 
 */
public class AdvantageShuffleSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int n = nums1.length;
        Integer[] key = new Integer[n];
        for (int i = 0; i < n; i++) {
            key[i] = i;
        }
        Arrays.sort(key, (o1, o2) -> nums2[o1] - nums2[o2]);
        int[] res = new int[n];
        int i = n - 1;
        for (int j = n - 1; j >= 0; j--) {
            if (nums2[key[j]] < nums1[i]) {
                res[key[j]] = nums1[i];
                i--;
            }
        }
        for (int p = 0; p < n; p++) {
            if (res[p] == 0) res[p] = nums1[i--];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
