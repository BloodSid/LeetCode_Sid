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
    public int add(int a, int b) {
        // 执行到进位为0时结束
        if (b == 0) {
            return a;
        }
        int xorSum = a ^ b;
        // 这里写 int carry = (~xorSum) & a; 也可以
        int carry = a & b;
        return add(xorSum, (carry << 1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
