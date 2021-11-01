package leetcode.editor.cn;

import java.util.*;

/**
 * 移除元素
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-01 10:52:18 
 */
public class RemoveElementSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
