package leetcode.editor.cn;

import java.util.*;

/**
 * 汇总区间
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-05 23:44:38 
 */
public class SummaryRangesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> list = new ArrayList<>();
        int r = 0;
        for (int l = 0; l < n; l = r) {
            while (l == r || r < n && nums[r] == nums[r - 1] + 1) {
                r++;
            }
            if (l + 1 == r) {
                list.add(String.valueOf(nums[l]));
            } else {
                list.add(nums[l] + "->" + nums[r - 1]);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
