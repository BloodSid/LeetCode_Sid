package leetcode.editor.cn;

import java.util.*;

/**
 * 和为 K 的最少斐波那契数字数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-03 00:08:22
 */
public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsKSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] fib;

    {
        fib = new int[46];
        fib[1] = fib[2] = 1;
        for (int i = 3; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
    }

    public int findMinFibonacciNumbers(int k) {
        int p = fib.length - 1;
        int cnt = 0;
        while (k != 0) {
            while (fib[p] > k) {
                p--;
            }
            k -= fib[p];
            cnt++;
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
