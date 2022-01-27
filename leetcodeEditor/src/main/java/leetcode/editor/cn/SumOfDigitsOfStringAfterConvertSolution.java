package leetcode.editor.cn;

import java.util.*;

/**
 * 字符串转化后的各位数字之和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-27 22:35:58
 */
public class SumOfDigitsOfStringAfterConvertSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getLucky(String s, int k) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c - 'a' + 1);
        }
        for (int i = 0; i < k; i++) {
            int tem = 0;
            for (int i1 = 0; i1 < sb.length(); i1++) {
                tem += sb.charAt(i1) - '0';
            }
            sb = new StringBuilder().append(tem);
        }
        return Integer.parseInt(sb.toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
