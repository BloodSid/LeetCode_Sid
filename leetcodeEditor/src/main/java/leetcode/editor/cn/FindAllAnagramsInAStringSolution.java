package leetcode.editor.cn;

import java.util.*;

/**
 * 找到字符串中所有字母异位词
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-28 23:17:33
 */
public class FindAllAnagramsInAStringSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int offset = p.length();
        List<Integer> ans = new ArrayList<>();
        int[] freq = new int[26];
        char[] arr = s.toCharArray();
        for (int i = 0; i < offset; i++) {
            freq[p.charAt(i) - 'a']--;
            freq[arr[i] - 'a']++;
        }
        for (int i = 0; i <= arr.length - offset; i++) {
            int j = 0;
            for (; j < freq.length; j++) {
                if (freq[j] != 0) {
                    break;
                }
            }
            if (j == 26) {
                ans.add(i);
            }
            if (i < arr.length - offset) {
                freq[arr[i] - 'a']--;
                freq[arr[i + offset] - 'a']++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
