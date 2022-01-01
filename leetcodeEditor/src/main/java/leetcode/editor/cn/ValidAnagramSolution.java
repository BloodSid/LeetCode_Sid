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
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < sLen; i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
