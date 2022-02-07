package leetcode.editor.cn;

import java.util.*;

/**
 * 位1的个数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-08 00:27:52
 */
public class NumberOf1BitsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
