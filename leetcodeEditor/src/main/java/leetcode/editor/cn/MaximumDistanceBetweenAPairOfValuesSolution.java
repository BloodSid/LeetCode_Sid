package leetcode.editor.cn;

/**
 * 下标对中的最大距离
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-19 09:32:22 
 */
public class MaximumDistanceBetweenAPairOfValuesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (; j < nums2.length - 1 && nums1[i] <= nums2[j + 1]; j++) {}
            max = Math.max(max, j - i);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
