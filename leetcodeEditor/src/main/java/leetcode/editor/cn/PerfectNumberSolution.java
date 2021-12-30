package leetcode.editor.cn;

import java.util.*;

/**
 * 完美数
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-31 00:34:58
 */
public class PerfectNumberSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPerfectNumber(int num) {
        int[] perfectNums = {6, 28, 496, 8128, 33550336};
        List<Integer> list = new ArrayList<>();
        for (int perfectNum : perfectNums) {
            list.add(perfectNum);
        }
        return list.contains(num);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
