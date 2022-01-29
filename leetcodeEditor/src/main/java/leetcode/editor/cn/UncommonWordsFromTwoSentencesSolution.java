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
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String s : s1.split("\\s")) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split("\\s")) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (String s : map1.keySet()) {
                if (map1.get(s) == 1 && !map2.containsKey(s)) {
                    res.add(s);
                }
            }
            HashMap<String, Integer> temp = map1;
            map1 = map2;
            map2 = temp;
        }
        return res.toArray(new String[0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
