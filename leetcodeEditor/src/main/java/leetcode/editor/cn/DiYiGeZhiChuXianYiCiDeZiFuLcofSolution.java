package leetcode.editor.cn;

import java.util.*;

/**
 * 第一个只出现一次的字符
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-31 22:40:18
 */
public class DiYiGeZhiChuXianYiCiDeZiFuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
