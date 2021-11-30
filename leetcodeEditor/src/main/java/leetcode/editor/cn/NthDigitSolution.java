package leetcode.editor.cn;

import java.util.*;

/**
 * 第 N 位数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-30 12:19:57
 */
public class NthDigitSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findNthDigit(int n) {
        int width = 1;
        int len = 9;
        while (n / width > len) {
            n -= len * width;
            width++;
            len *= 10;
        }
        int base = 1;
        for (int i = 0; i < width - 1; i++) {
            base *= 10;
        }
        int number = base + (n - 1) / width;
        for (int i = 0; i < width - (n - 1) % width - 1; i++) {
            number /= 10;
        }
        return number % 10;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
