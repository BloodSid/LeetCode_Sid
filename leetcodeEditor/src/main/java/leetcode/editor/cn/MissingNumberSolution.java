package leetcode.editor.cn;

import java.util.*;

/**
 * 丢失的数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-06 11:55:19 
 */
public class MissingNumberSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        int xorSum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xorSum ^= i;
            xorSum ^= nums[i];
        }
        return xorSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
