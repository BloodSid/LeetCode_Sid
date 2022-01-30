package leetcode.editor.cn;

import java.util.*;

/**
 * 将数字变成 0 的操作次数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-31 00:49:43
 */
public class NumberOfStepsToReduceANumberToZeroSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfSteps(int num) {
        return Integer.bitCount(num) + Integer.toBinaryString(num).length() - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
