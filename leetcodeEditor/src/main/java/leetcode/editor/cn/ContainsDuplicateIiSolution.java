package leetcode.editor.cn;

import java.util.*;

/**
 * 存在重复元素 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-19 11:58:17
 */
public class ContainsDuplicateIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(k);
        for (int i = 0; i < Math.min(k, nums.length); i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        for (int i = 0, j = k; j < nums.length; i++, j++) {
            if (!set.add(nums[j])) {
                return true;
            }
            set.remove(nums[i]);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
