package leetcode.editor.cn;

import java.util.*;

/**
 * 字符串相乘
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-11 14:47:30 
 */
public class MultiplyStringsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] tem = new int[num1.length() + num2.length() - 1];
        for (int i = 0; i < num1.length(); i++) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int digit2 = num2.charAt(j) - '0';
                tem[i + j] += digit1 * digit2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = tem.length - 1; i > 0; i--) {
            sb.append(tem[i] % 10);
            tem[i - 1] += tem[i] / 10;
        }
        while (tem[0] != 0) {
            sb.append(tem[0] % 10);
            tem[0] /= 10;
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
