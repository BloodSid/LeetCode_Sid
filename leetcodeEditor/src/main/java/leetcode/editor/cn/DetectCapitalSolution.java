package leetcode.editor.cn;

import java.util.*;

/**
 * 检测大写字母
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-13 12:03:15
 */
public class DetectCapitalSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) {
            return true;
        }
        if (Character.isUpperCase(word.charAt(1)) && Character.isLowerCase(word.charAt(0))) {
            return false;
        }
        for (int i = 2; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(1)) ^ Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
