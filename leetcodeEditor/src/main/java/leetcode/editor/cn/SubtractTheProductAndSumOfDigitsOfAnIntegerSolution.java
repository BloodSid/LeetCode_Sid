package leetcode.editor.cn;

import java.util.*;

/**
 * 整数的各位积和之差
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-08 00:27:58
 */
public class SubtractTheProductAndSumOfDigitsOfAnIntegerSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        for (; n != 0; n /= 10) {
            int digit = n % 10;
            product *= digit;
            sum += digit;
        }
        return product - sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
