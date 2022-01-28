package leetcode.editor.cn;

import java.util.*;

/**
 * 二进制求和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-28 22:25:10
 */
public class AddBinarySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int RADIX = 2;

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        char[] sum = new char[a.length() + 1];
        int carry = 0;
        for (int i = 0; i < a.length(); i++) {
            char temp = a.charAt(a.length() - 1 - i);
            temp += carry;
            if (b.length() - 1 - i >= 0) {
                temp += b.charAt(b.length() - 1 - i) - '0';
            }
            carry = (temp - '0') / RADIX;
            sum[sum.length - 1 - i] = (char) ('0' + temp % RADIX);
        }
        if (carry == 1) {
            sum[0] = '1';
            return new String(sum);
        }
        return new String(sum, 1, a.length());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
