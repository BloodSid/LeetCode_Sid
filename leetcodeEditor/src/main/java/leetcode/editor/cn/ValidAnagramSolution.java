package leetcode.editor.cn;

import java.util.*;

/**
 * 有效的字母异位词
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-01 20:08:40
 */
public class ValidAnagramSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }
        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
