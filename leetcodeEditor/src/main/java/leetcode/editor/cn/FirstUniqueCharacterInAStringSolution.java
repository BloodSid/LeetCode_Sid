package leetcode.editor.cn;

import java.util.*;

/**
 * 字符串中的第一个唯一字符
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-01 20:20:48
 */
public class FirstUniqueCharacterInAStringSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        int index = Integer.MAX_VALUE;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int head = s.indexOf(ch);
            if (head != -1 && head == s.lastIndexOf(ch)) {
                if (head < index) {
                    index = head;
                }
            }
        }
        return index == Integer.MAX_VALUE ? -1 : index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
