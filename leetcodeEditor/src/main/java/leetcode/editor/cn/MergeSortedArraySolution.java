package leetcode.editor.cn;

import java.util.*;

/**
 * 合并两个有序数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-29 00:16:46 
 */
public class MergeSortedArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
