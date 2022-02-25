package leetcode.editor.cn;

import java.util.*;

/**
 * 复数乘法
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-25 09:30:10
 */
public class ComplexNumberMultiplicationSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] s1 = num1.split("[+i]");
        String[] s2 = num2.split("[+i]");
        int r1 = Integer.parseInt(s1[0]);
        int i1 = Integer.parseInt(s1[1]);
        int r2 = Integer.parseInt(s2[0]);
        int i2 = Integer.parseInt(s2[1]);
        int r = r1 * r2 - i1 * i2;
        int i = r1 * i2 + r2 * i1;
        return r + "+" + i + "i";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
