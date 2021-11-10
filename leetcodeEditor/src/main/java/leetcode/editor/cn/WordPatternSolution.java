package leetcode.editor.cn;

import java.util.*;

/**
 * 单词规律
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-10 13:01:40 
 */
public class WordPatternSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(words[i])) {
                if (map.get(words[i]) != c) {
                    return false;
                }
            } else {
                if (map.containsValue(c)) {
                    return false;
                }
                map.put(words[i], c);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
