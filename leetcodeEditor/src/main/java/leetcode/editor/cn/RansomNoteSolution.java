package leetcode.editor.cn;

import java.util.*;

/**
 * 赎金信
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-01 20:18:10
 */
public class RansomNoteSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // magazine的词频
        int[] freq = new int[128];
        for (char c : magazine.toCharArray()) {
            freq[c]++;
        }
        for (char c : ransomNote.toCharArray()) {
            freq[c]--;
            if (freq[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
