package leetcode.editor.cn;

import java.util.*;

/**
 * 串联所有单词的子串
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-28 23:12:41 
 */
public class SubstringWithConcatenationOfAllWordsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashSet<String> dict = new HashSet<>();
        Collections.addAll(dict, words);
        int len = words[0].length();
        int m = words.length;
        char[] ch = s.toCharArray();
        int n = ch.length;
        HashSet<String> cur = new HashSet<>();
        // 目标子串的长度 target
        ArrayList<Integer> res = new ArrayList<>();
        for (int offset = 0; offset < len; offset++) {
            // 滑动窗口
            int l = offset, r = offset;
            for (; r + len <= n; r += len) {
                String sub = new String(ch, r, len);
                if (!dict.contains(sub)) {
                    l = r + len;
                    cur.clear();
                }
                if (cur.contains(sub)) {
                    while (l < r) {
                        String del = new String(ch, l, len);
                        if (sub.equals(del)) {
                            l += len;
                            break;
                        } else {
                            cur.remove(del);
                            l += len;
                        }
                    }
                } else {
                    cur.add(sub);
                }
                if (cur.size() == m) res.add(l);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
