package leetcode.editor.cn;

import java.util.*;

/**
 * 0～n-1中缺失的数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-30 21:36:50
 */
public class QueShiDeShuZiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
