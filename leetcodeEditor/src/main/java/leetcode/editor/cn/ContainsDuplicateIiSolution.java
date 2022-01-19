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
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int last = map.get(nums[i]);
                if (i - last <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
