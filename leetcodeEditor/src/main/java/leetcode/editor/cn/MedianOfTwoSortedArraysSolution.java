package leetcode.editor.cn;

import java.util.*;

/**
 * 寻找两个正序数组的中位数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-19 19:06:25
 */
public class MedianOfTwoSortedArraysSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 设nums1短而nums2长
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // 把两个数组都分为前后两段，前段长度之和为sum1，后段长度之和为sum2，要使sum2等于sum1或sum1+1 （对应总长度的偶数和奇数）
        // 二分搜索nums1的索引，每个索引对应一种分法
        int l = 0, r = len1 - 1;
        while (l <= r) {
            // l, r 是数组下标，范围必然比int范围小很多所以不反溢出
            int mid = l + r >>> 1;
            if (nums1[mid] < nums2[(len1 + len2) / 2 - mid - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // 此时的l恰使得两个前段的最后一个元素都小于两个后段的第一个元素。
        int index1 = l;
        int index2 = (len1 + len2) / 2 - l;
        int greater;
        if (index1 != len1 && index2 != len2) {
            greater = Math.min(nums1[index1], nums2[index2]);
        } else {
            greater = index1 == len1 ? nums2[index2] : nums1[index1];
        }
        if ((len1 + len2 & 1) == 1) {
            return greater;
        } else {
            int smaller;
            if (index1 - 1 != -1 && index2 - 1 != -1) {
                smaller = Math.max(nums1[index1 - 1], nums2[index2 - 1]);
            } else {
                smaller = index1 - 1 == -1 ? nums2[index2 - 1] : nums1[index1 - 1];
            }
            return (greater + smaller) / 2.0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
