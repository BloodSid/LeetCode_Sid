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
        int p1 = m - 1;
        int p2 = n - 1;
        int cur = n + m - 1;
        while (cur >= 0) {
            if (p1 < 0) {
                nums1[cur] = nums2[p2];
                p2--;
            } else if (p2 < 0) {
                nums1[cur] = nums1[p1];
                p1--;
            } else if (nums1[p1] < nums2[p2]) {
                nums1[cur] = nums2[p2];
                p2--;
            } else {
                nums1[cur] = nums1[p1];
                p1--;
            }
            cur--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
