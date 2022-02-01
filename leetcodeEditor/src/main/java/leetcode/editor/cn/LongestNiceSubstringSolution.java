package leetcode.editor.cn;

import java.util.*;

/**
 * 最长的美好子字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-01 11:01:06
 */
public class LongestNiceSubstringSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestNiceSubstring(String s) {
        char[] arr = s.toCharArray();
        // (c & 32) == 0 true 小写 false 大写
        int n = s.length();
        for (int len = n; len > 0; len--) {
            for (int start = 0; start + len <= n; start++) {
                int upper = 0;
                int lower = 0;
                for (int i = start; i < start + len; i++) {
                    if ((arr[i] & 32) == 0) {
                        lower |= 1 << (arr[i] & 31);
                    } else {
                        upper |= 1 << (arr[i] & 31);
                    }
                }
                if (upper == lower) {
                    return s.substring(start, start + len);
                }
            }
        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
