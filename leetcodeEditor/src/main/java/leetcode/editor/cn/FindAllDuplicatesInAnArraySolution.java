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
            while (nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i) {
                res.add(nums[i]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
