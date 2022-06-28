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
        int len = words[0].length();
        int m = words.length;
        char[] ch = s.toCharArray();
        int n = ch.length;
        Map<String, Integer> dict = new HashMap<>();
        int[] f = new int[m];
        for (String word : words) {
            Integer idx = dict.get(word);
            if (idx == null) {
                int size = dict.size();
                dict.put(word, size);
                idx = size;
            }
            f[idx]++;
        }
        int[] copy = Arrays.copyOf(f, f.length);
        ArrayList<Integer> res = new ArrayList<>();
        for (int offset = 0; offset < len; offset++, f = Arrays.copyOf(copy, f.length)) {
            // 滑动窗口
            int l = offset, r = offset;
            for (; r + len <= n; r += len) {
                String sub = new String(ch, r, len);
                if (!dict.containsKey(sub)) {
                    l = r + len;
                    f = Arrays.copyOf(copy, f.length);
                    continue;
                }
                int idx = dict.get(sub);
                if (f[idx] == 0) {
                    while (l < r) {
                        String del = new String(ch, l, len);
                        if (sub.equals(del)) {
                            l += len;
                            break;
                        } else {
                            f[dict.get(del)]++;
                            l += len;
                        }
                    }
                } else {
                    f[idx]--;
                }
                int i;
                for (i = 0; i < f.length; i++) {
                    if (f[i] != 0) break;
                }
                if (i == f.length) res.add(l);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
