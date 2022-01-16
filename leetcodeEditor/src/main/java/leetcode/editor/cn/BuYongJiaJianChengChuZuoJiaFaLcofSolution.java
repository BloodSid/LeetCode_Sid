package leetcode.editor.cn;

import java.util.*;

/**
 * 不用加减乘除做加法
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-16 09:50:32
 */
public class BuYongJiaJianChengChuZuoJiaFaLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // int用补码存储，所以对正数负数的加法通用
    public int add(int a, int b) {
        int carry;
        // 执行到进位为0时结束
        while (b != 0) {
            // 进位
            carry = (a & b) << 1;
            // 无进位和
            a ^= b;
            b = carry;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
