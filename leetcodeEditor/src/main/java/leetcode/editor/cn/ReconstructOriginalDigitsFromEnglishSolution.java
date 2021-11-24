package leetcode.editor.cn;

import java.util.*;

/**
 * 从英文中重建数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-24 08:21:17
 */
public class ReconstructOriginalDigitsFromEnglishSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String originalDigits(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int[] cnt = new int[10];
        cnt[0] = freq['z' - 'a'];
        cnt[2] = freq['w' - 'a'];
        cnt[4] = freq['u' - 'a'];
        cnt[6] = freq['x' - 'a'];
        cnt[8] = freq['g' - 'a'];
        cnt[3] = freq['h' - 'a'] - cnt[8];
        cnt[5] = freq['f' - 'a'] - cnt[4];
        cnt[7] = freq['s' - 'a'] - cnt[6];
        cnt[1] = freq['o' - 'a'] - cnt[0] - cnt[2] - cnt[4];
        cnt[9] = freq['i' - 'a'] - cnt[5] - cnt[6] - cnt[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int i1 = 0; i1 < cnt[i]; i1++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
