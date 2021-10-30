package leetcode.editor.cn;

import java.util.*;

/**
 * 只出现一次的数字 III
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-30 13:07:31
 */
public class SingleNumberIiiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int i = 0; i < nums.length; i++) {
            xorsum = xorsum ^ nums[i];
        }
        int lowestBit = xorsum & (-xorsum);
        int xorsum0 = 0;
        int xorsum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((lowestBit & nums[i]) == 0) {
                xorsum0 = xorsum0 ^ nums[i];
            } else {
                xorsum1 = xorsum1 ^ nums[i];
            }
        }
        return new int[]{xorsum0, xorsum1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
