package leetcode.editor.cn;

import java.util.*;

/**
 * 最常见的单词
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-17 00:27:55
 */
public class MostCommonWordSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, banned);
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        String res = null;
        for (String s : paragraph.split("\\W+")) {
            if (s.length() == 0) continue;
            s = s.toLowerCase();
            if (set.contains(s)) continue;
            int cnt = map.getOrDefault(s, 0) + 1;
            if (cnt > max) {
                max = cnt;
                res = s;
            }
            map.put(s, cnt);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
