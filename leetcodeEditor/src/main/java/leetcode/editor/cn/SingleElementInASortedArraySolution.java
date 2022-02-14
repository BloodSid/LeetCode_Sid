package leetcode.editor.cn;

import java.util.*;

/**
 * 有序数组中的单一元素
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-14 16:55:40
 */
public class SingleElementInASortedArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >>> 1;
            if (nums[mid] == nums[(mid & 1) == 1 ? mid - 1 : mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
