package leetcode.editor.cn;

import java.util.*;

/**
 * 数组中重复的数据
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-08 00:09:10
 */
public class FindAllDuplicatesInAnArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val - 1] > 0) {
                nums[val - 1] = -nums[val - 1];
            } else {
                res.add(val);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
