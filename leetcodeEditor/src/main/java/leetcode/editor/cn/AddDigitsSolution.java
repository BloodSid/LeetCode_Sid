package leetcode.editor.cn;

import java.util.*;

/**
 * 各位相加
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-03 13:58:03
 */
public class AddDigitsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0;
        return (num - 1) % 9 + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
