package leetcode.editor.cn;

import java.util.*;

/**
 * 只出现一次的数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-05 00:20:26 
 */
public class SingleNumberSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        return xorSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
