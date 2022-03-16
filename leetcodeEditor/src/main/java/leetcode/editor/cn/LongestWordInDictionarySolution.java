package leetcode.editor.cn;

import java.util.*;

/**
 * 词典中最长的单词
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-17 01:08:27
 */
public class LongestWordInDictionarySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestWord(String[] words) {
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, words);
        int maxLen = 0;
        String longest = "";
        loop:
        for (String word : words) {
            int len = word.length();
            if (len < maxLen) {
                continue;
            }
            if (len == maxLen && longest.compareTo(word) < 0) {
                continue;
            }
            for (int i = 1; i < len; i++) {
                if (!set.contains(word.substring(0, i))) {
                    continue loop;
                }
            }
            maxLen = len;
            longest = word;
        }
        return longest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
