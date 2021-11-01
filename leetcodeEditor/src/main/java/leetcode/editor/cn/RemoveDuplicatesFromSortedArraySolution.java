package leetcode.editor.cn;

import java.util.*;

/**
 * 删除有序数组中的重复项
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-31 21:27:12 
 */
public class RemoveDuplicatesFromSortedArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
