package leetcode.editor.cn;

import java.util.*;

/**
 * 验证外星语词典
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-14 17:41:57
 */
public class VerifyingAnAlienDictionarySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] hash = new int[128];
        for (int i = 0; i < 26; i++) {
            hash[order.charAt(i)] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], hash) > 0) {
                return false;
            }
        }
        return true;
    }

    int compare(String a, String b, int[] hash) {
        int l1 = a.length();
        int l2 = b.length();
        int l = Math.min(l1, l2);
        for (int i = 0; i < l; i++) {
            int diff = hash[a.charAt(i)] - hash[b.charAt(i)];
            if (diff != 0) {
                return diff;
            }
        }
        if (l1 == l2) {
            return 0;
        }
        return l1 == l ? -1 : 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
