package leetcode.editor.cn;

import java.util.*;

/**
 * 丑数
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-18 21:40:35
 */
public class UglyNumberSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] primes = {2, 3, 5};

    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        for (int prime : primes) {
            while (n % prime == 0) {
                n /= prime;
            }
        }
        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
