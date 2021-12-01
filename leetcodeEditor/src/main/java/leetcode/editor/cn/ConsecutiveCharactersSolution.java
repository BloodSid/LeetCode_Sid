package leetcode.editor.cn;

import java.util.*;

/**
 * 连续字符
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-01 16:37:57
 */
public class ConsecutiveCharactersSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPower(String s) {
        int cnt = 1;
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cnt++;
            } else {
                cnt = 1;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
