package leetcode.editor.cn;

import java.util.*;

/**
 * 把字符串转换成整数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-23 14:33:29
 */
public class BaZiFuChuanZhuanHuanChengZhengShuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strToInt(String str) {
        int i = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                break;
            }
        }
        if (i == str.length()) {
            return 0;
        }
        boolean negative = false;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            negative = str.charAt(i) == '-';
            i++;
        }
        int ans = 0;
        for (; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            // 不是数字则终止
            if (digit < 0 || digit > 9) {
                break;
            }
            if (ans > Integer.MAX_VALUE / 10) {
                return Integer.MAX_VALUE;
            }
            if (ans < Integer.MIN_VALUE / 10) {
                return Integer.MIN_VALUE;
            }
            ans *= 10;
            if (negative) {
                digit = -digit;
                if (ans < Integer.MIN_VALUE - digit) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if (ans > Integer.MAX_VALUE - digit) {
                    return Integer.MAX_VALUE;
                }
            }
            ans += digit;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
