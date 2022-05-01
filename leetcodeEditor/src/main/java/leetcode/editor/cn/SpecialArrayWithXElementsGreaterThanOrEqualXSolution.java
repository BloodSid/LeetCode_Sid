package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 特殊数组的特征值
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-19 09:30:17
 */
public class SpecialArrayWithXElementsGreaterThanOrEqualXSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] < 0) return 0;
        if (nums[0] >= n) return n;
        for (int x = 1; x < n; x++) {
            if (nums[n - x] >= x && nums[n - x - 1] < x) return x;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
