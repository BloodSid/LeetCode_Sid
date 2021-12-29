package leetcode.editor.cn;

import java.util.*;

/**
 * 两个数组的交集 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-29 20:46:19 
 */
public class IntersectionOfTwoArraysIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = 1001;
        int[] freq1 = new int[n];
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        for (int i : nums1) {
            freq1[i]++;
        }
        int len = 0;
        for (int i : nums2) {
            if (freq1[i] != 0) {
                freq1[i]--;
                result[len] = i;
                len++;
            }
        }
        return Arrays.copyOfRange(result, 0, len);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
