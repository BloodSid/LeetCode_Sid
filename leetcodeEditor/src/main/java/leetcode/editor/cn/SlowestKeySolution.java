package leetcode.editor.cn;

import java.util.*;

/**
 * 按键持续时间最长的键
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-09 10:55:56
 */
public class SlowestKeySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        char ch = keysPressed.charAt(0);
        for (int i = releaseTimes.length - 1; i >= 1; i--) {
            releaseTimes[i] -= releaseTimes[i - 1];
            char key = keysPressed.charAt(i);
            if (releaseTimes[i] > max) {
                max = releaseTimes[i];
                ch = key;
            } else if (releaseTimes[i] == max && key > ch) {
                ch = key;
            }
        }
        return ch;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
