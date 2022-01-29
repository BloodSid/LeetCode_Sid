package leetcode.editor.cn;

import java.util.*;

/**
 * 两句话中的不常见单词
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-30 00:05:03
 */
public class UncommonWordsFromTwoSentencesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : s1.split("\\s")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split("\\s")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                res.add(s);
            }
        }
        return res.toArray(new String[0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
