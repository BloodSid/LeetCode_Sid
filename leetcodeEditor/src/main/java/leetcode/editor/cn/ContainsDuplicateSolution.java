package leetcode.editor.cn;

import java.util.*;

/**
 * 存在重复元素
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-29 00:18:17
 */
public class ContainsDuplicateSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
