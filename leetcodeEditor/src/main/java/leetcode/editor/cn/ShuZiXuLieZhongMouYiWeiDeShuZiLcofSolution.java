package leetcode.editor.cn;

import java.util.*;

/**
 * 数字序列中某一位的数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-26 13:40:12
 */
public class ShuZiXuLieZhongMouYiWeiDeShuZiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        int preBase = 0;
        int base = 10;
        int width = 1;
        int idx = n;
        // 注意 width*(base-preBase)可能会溢出所以用除法代替不等式中的乘法
        while (idx / width >= base - preBase) {
            idx -= width * (base - preBase);
            preBase = base;
            base *= 10;
            width++;
        }
        int num = preBase + idx / width;
        for (int i = 0; i < width - 1 - idx % width; i++) {
            num /= 10;
        }
        return num % 10;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
