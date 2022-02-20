package leetcode.editor.cn;

import java.util.*;

/**
 * 1比特与2比特字符
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-20 21:54:45
 */
public class OneBitAnd2BitCharactersSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int idx = 0;
        while (idx < n - 1) {
            idx += bits[idx] == 1 ? 2 : 1;
        }
        return idx == n - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
