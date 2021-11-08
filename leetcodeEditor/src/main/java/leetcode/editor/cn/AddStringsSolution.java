package leetcode.editor.cn;

import java.util.*;

/**
 * 字符串相加
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-09 00:58:33 
 */
public class AddStringsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        if (num2.length() > num1.length()) {
            String tem = num1;
            num1 = num2;
            num2 = tem;
        }
        char[] ans = num1.toCharArray();
        int l1 = num1.length();
        int l2 = num2.length();
        for (int i = 0; i < ans.length; i++) {
            if (l2 - 1 - i >= 0) {
                ans[l1 - 1 - i] += num2.charAt(l2 - 1 - i) - '0';
            }
            if (i < l1 - 1 && ans[l1 - 1 - i] > '9') {
                ans[l1 - 1 - i] -= 10;
                ans[l1 - 2 - i]++;
            }
        }
        if (ans[0] > '9') {
            ans[0] -= 10;
            return '1' + String.valueOf(ans);
        }
        return new String(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
