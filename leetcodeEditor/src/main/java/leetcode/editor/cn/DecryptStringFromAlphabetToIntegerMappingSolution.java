package leetcode.editor.cn;

import java.util.*;

/**
 * 解码字母到整数映射
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-14 17:31:54
 */
public class DecryptStringFromAlphabetToIntegerMappingSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String freqAlphabets(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i < n - 2 && a[i + 2] == '#') {
                sb.append((char) (((a[i] & 15) * 10 + (a[i + 1] & 15)) - 1 + 'a'));
                i += 2;
            } else {
                sb.append((char) ((a[i] & 15) - 1 + 'a'));
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
